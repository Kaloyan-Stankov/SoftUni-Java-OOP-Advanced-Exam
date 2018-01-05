package app.engine;

import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineImpl implements Engine {

    private static final String TERMINATE_COMMAND = "Peace";

    private Reader reader;
    private Writer writer;
    private Battlefield battlefield;

    public EngineImpl(Battlefield battlefield, Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
        this.battlefield = battlefield;
    }

    @Override
    public void run() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        while (true) {
            List<String> tokens = null;
            try {
                tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }

            switch (tokens.get(0).toLowerCase()){
                case "createparticipant" :
                    battlefield.createParticipant(tokens.get(1),tokens.get(2));
                    break;
                case "createaction" :
                    battlefield.createAction(tokens.get(1),
                            Arrays.copyOf(tokens.stream().skip(2).toArray(),
                                   tokens.stream().skip(2).toArray().length,
                                    String[].class));
                    break;
                case "statparticipants":
                    battlefield.reportParticipants();
                    break;
                case "statactions":
                    battlefield.reportActions();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }



        }
    }
}
