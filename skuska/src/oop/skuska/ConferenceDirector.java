package oop.skuska;

public class ConferenceDirector {
    private EmailBuilderInterface builder;
    private String sender;
    private String receiver;

    public ConferenceDirector(EmailBuilderInterface builder, String sender, String receiver) {
        this.builder = builder;
        this.sender = sender;
        this.receiver = receiver;
    }

    void invite(String receiverAdress, String receiverName, String conferenceName, String location, String date, String time){

        builder.setSender(sender);
        builder.setReceiver(receiverAdress);
        builder.setSubject(String.format("%s (invitation)", conferenceName));
        builder.setContent(String.format("""
                Dear %s,
                We are pleased to invite you to our upcoming conference, %s.
                The conference is scheduled to take place on %s, at %s, in %s.
                Sincerely,
                %s
                """, receiverName, conferenceName, date, time, location, receiver));
    }

    void confirm(String receiverAdress, String receiverName, String conferenceName) {
        builder.setSender(sender);
        builder.setReceiver(receiverAdress);
        builder.setSubject(String.format("%s (registration confirmation)", conferenceName));
        builder.setContent(String.format("""
                Dear %s,
                We are delighted to confirm your registration for the %s conference.
                Singecerly,
                %s
                """, receiverName, conferenceName, receiver));
    }

    // v komentaroch su popisane
    //  - parametre konstruktora a metod
    //  - texty, aby ste ich nemuseli prepisovat rucne (pre zostavenie mozete pouzit funkciu String.format)

    // constructor(builder, adresa odosielatela, meno odosielatela) {
    // }

    // pozvanka na konferenciu
    // void invite(adresa prijimatela, meno prijimatela, nazov konferencie, miesto konania, datum konania, cas konania) {

        // predmet spravy
        // "%s (invitation)"

        // obsah emailu
        // """
        // Dear %s,
        // We are pleased to invite you to our upcoming conference, %s.
        // The conference is scheduled to take place on %s, at %s, in %s.
        // Sincerely,
        // %s
        //     """

    // }

    // potvrdenie rezervacie
    // void confirm(adresa prijimatela, meno prijimatela, nazov konferencie) {

        // predmet spravy
        // "%s (registration confirmation)"

        // obsah emailu
        // """
        // Dear %s,
        // We are delighted to confirm your registration for the %s conference.
        // Singecerly,
        // %s
        // """

    // }
}
