package sample;

public class ViewMana implements Observer{

    private ManaReserve manaReserve;

    public ViewMana(){
        this.manaReserve = new ManaReserve(0,0);
        ViewMana viewMana= this;
        manaReserve.addObserver(viewMana);
    }

    public ManaReserve getManaReserve(){ return this.manaReserve;}

    @Override
    public void update(ManaReserve manaReserve){
        System.out.println("Value Update");
    }


}
