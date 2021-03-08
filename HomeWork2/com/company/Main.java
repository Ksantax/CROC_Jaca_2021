package com.company;

/**
 * Main class that have program enter pont
 * @author ChekhovAI
 */
public class Main {
    /**
     * Method to enter the program - main
     * @param args - args from command line (Terminal)
     */
    public static void main(String[] args) {
        // Creating magazine for buying media devices
        MediaFabric mVideo = new MediaFabric();

        // Buy some media devices
        MediaDevice sdPlayer = mVideo.getSDPlayer("Yamaha CRX-B370");
        MediaDevice vinylPlayer = mVideo.getVinylPlayer("Aria-102-Stereo");
        MediaDevice mediaCenter = mVideo.getMediaStation("JBL Party XS");

        // Create some carriers with music
        Carrier disk = new Disk(
                new Song("Travis Scott", "SICKO MODE"),
                new Song("Travis Scott", "HIGHEST IN THE ROOM"),
                new Song("Travis Scott", "ZEZE")
        );
        Carrier sdCard = new SDCard(
                new Song("Juice WRLD", "Lucid Dreams"),
                new Song("Juice WRLD", "Hate me"),
                new Song("Juice WRLD", "Come & Go")
        );
        Carrier vinylDisk = new VinylDisk(
                new Song("Eminem", "Godzilla"),
                new Song("Eminem", "Zeus"),
                new Song("Eminem", "Gnat")
        );

        // Try to play without insertion carrier
        try {
            mediaCenter.playFromCarrier();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }

        // Try ro insert not supported carrier
        try {
            sdPlayer.insertCarrier(disk);
        } catch (InsertionException ex) {
            System.out.println(ex.getMessage());
        }

        // Insert supported devices and play music
        try {
            mediaCenter.insertCarrier(disk);
            sdPlayer.insertCarrier(sdCard);
            vinylPlayer.insertCarrier(vinylDisk);
            mediaCenter.playFromCarrier();
            sdPlayer.playFromCarrier();
            vinylPlayer.playFromCarrier();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Extract carriers
        sdPlayer.extractCarrier();
        vinylPlayer.extractCarrier();
        mediaCenter.extractCarrier();

        // Try to insert different carriers to universal media device
        try {
            mediaCenter.insertCarrier(disk);
            mediaCenter.insertCarrier(vinylDisk);
            mediaCenter.insertCarrier(sdCard);
        } catch (InsertionException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            mediaCenter.playFromCarrier();
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        mediaCenter.extractCarrier();
    }
}
