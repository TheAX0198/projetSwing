package pkgMVC;

public class Modele implements DBPoke {

    public Pokemon randomPoke() {
        int randomInt = (int) Math.round(Math.random() * (LISTEPOKEMON.length - 1));
        Pokemon poke = LISTEPOKEMON[randomInt];
        return poke;
    }

    public int randInt(int min, int max) {
        return (int) Math.round(Math.random() * (max - min)) + min;
    }
}
