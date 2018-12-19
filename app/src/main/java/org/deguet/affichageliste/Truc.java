package org.deguet.affichageliste;

import java.util.Date;

public class Truc {

    public String contenu;
    public Date date;

    public Truc(String contenu) {
        this.contenu = contenu;
        this.date = new Date();
    }
}
