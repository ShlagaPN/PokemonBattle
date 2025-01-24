package attacks;

public class Attack {
    private String name;
    private int baseDamage;


    //Método constructor de los ataques
    public Attack(String name, int baseDamage) {
        this.name = name;
        this.baseDamage = baseDamage;
    }

     //Getters (principio de encapsulacion)
     public String getName() {
            return name;
        }
    
    public int getBaseDamage() {
        return baseDamage;
        }

    @Override
    public String toString() {
        return "Ataque: " + name + "   Daño base:" + baseDamage;
    } 

}

