package com.dp.blackhole.cli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dp.blackhole.common.PBwrap;
import com.dp.blackhole.common.gen.DumpReplyPB.DumpReply;
import com.dp.blackhole.common.gen.MessagePB.Message;
import com.dp.blackhole.common.gen.MessagePB.Message.MessageType;
import com.dp.blackhole.node.Node;

public class Cli extends Node {
    private static final Log LOG = LogFactory.getLog(Cli.class);
    private String[] args;
    private String autoCmd;

    class CliProcessor extends Thread {
        BufferedReader in;
        PrintStream out;
        PrintStream err;
        
        public CliProcessor() {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintStream(System.out);
            err = new PrintStream(System.err);
        }
        
        private String[] getTokens(String cmd) {
            return cmd.split("\\s+");
        }
        
        public void processCommand(String cmd) {
            if (cmd.equals("dumpstat")) {
                Message msg = PBwrap.wrapDumpStat();
                send(msg);
                out.println("send message: " + msg);
            } else if (cmd.startsWith("recovery")) {
                String[] tokens = getTokens(cmd);
                String appName = tokens[1];
                String appServer = tokens[2];
                long rollTs = Long.parseLong(tokens[3]); 
                Message msg = PBwrap.wrapManualRecoveryRoll(appName, appServer, rollTs);
                send(msg);
                out.println("send message: " + msg);
            } else if (cmd.startsWith("range")) {
                //recovery -a 3600 1385276400000 1385301600000
                String[] tokens = getTokens(cmd);
                String appName = tokens[1];
                String appServer = tokens[2];
                long period = Long.parseLong(tokens[3]);
                long startRollTs = Long.parseLong(tokens[4]);
                long endRollTs = Long.parseLong(tokens[5]);
                long recoveryStageCount = (endRollTs - startRollTs) / period / 1000;
                for (int i = 0; i<= recoveryStageCount; i++) {
                    long rollTs = startRollTs + period * 1000 * (i);
                    Message msg = PBwrap.wrapManualRecoveryRoll(appName, appServer, rollTs);
                    send(msg);
                    out.println("send message: " + msg);
                }
            } else if (cmd.startsWith("retire")) {
                String[] tokens = getTokens(cmd);
                String appName = tokens[1];
                String appServer = tokens[2];
                Message msg = PBwrap.wrapRetireStream(appName, appServer);
                send(msg);
                out.println("send message: " + msg);
            } else if (cmd.equals("dumpconf")) {
                Message msg = PBwrap.wrapDumpConf();
                send(msg);
                out.println("send message: " + msg);
            } else if (cmd.equals("listapps")) {
                Message msg = PBwrap.wrapListApps();
                send(msg);
                out.println("send message: " + msg);
            } else if (cmd.startsWith("rmconf")) {
                String[] tokens = getTokens(cmd);
                String appName = tokens[1];
                ArrayList<String> appServers = new ArrayList<String>();
                for (int i = 2; i < tokens.length; i++) {
                    appServers.add(tokens[i]);
                }
                Message msg = PBwrap.wrapRemoveConf(appName, appServers);
                send(msg);
            } else if (cmd.equals("quit")) {
                System.exit(0);
            } else {
                out.println("unknown command");
            }
        }
        
        @Override
        public void run() {
            String cmd;
            
            out.println("blackhole cli started:");
            out.print("blackhole.cli>");
            
            try {
                while ((cmd = in.readLine()) != null) {
                    processCommand(cmd);
                    out.print("blackhole.cli>");
                }
            } catch (Exception e) {
                e.printStackTrace(err);
            }
        }
    }
    
    class CloseTimer extends Thread {
        @Override
        public void run() {
            LOG.info("Currently Cli JVM will be terminated after 10 sec.");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                LOG.warn(e.getMessage());
            }
            LOG.info("Cli shutdown.");
            System.exit(0);
        }
    }
    
    @Override
    protected boolean process(Message msg) {
        MessageType type = msg.getType();
        switch (type) {
        case DUMPREPLY:
            DumpReply dumpReply = msg.getDumpReply();
            PrintStream out = new PrintStream(System.out);
            out.println("receive reply: ");
            out.println(dumpReply.getReply());
            out.print("blackhole.cli>");
            break;
        default:
            LOG.error("Illegal message type " + msg.getType());
        }
        return true;
    }

    @Override
    protected void onConnected() {
        if (autoCmd == null) {
            return;
        }
        CliProcessor processor = new CliProcessor();
        processor.processCommand(autoCmd.trim());
        new CloseTimer().start();
    }

    private void start() throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        prop.load(new FileReader(new File("config.properties")));
        
        String serverhost = prop.getProperty("supervisor.host");
        int serverport = Integer.parseInt(prop.getProperty("supervisor.port"));
        
        init(serverhost, serverport);
        
        if (args.length > 0 && args[0].equals("auto")) {
            String cmd = new String();
            for (int i = 1; i < args.length; i++) {
                cmd += args[i] + " ";
            }
            LOG.info("auto command: " + cmd);
            autoCmd = cmd.trim();
        } else {
            CliProcessor processor = new CliProcessor();
            processor.setDaemon(true);
            processor.start();
        }

        loop();
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Cli cli = new Cli();
        cli.args = args;
        cli.start();
    }
}