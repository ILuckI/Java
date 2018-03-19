public class Savings extends Account {

    private int saftyDepoBoxId;
    private int saftyDepoBoxKey;

    public Savings (String name, String sSN, double initDeposit ){
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;

        setSafetyDepoBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.15;
    }

    private void setSafetyDepoBox(){
        saftyDepoBoxId = (int) (Math.random() * Math.pow(10,3));
        saftyDepoBoxKey = (int) (Math.random() * Math.pow(10,4));
    }



    public void showInfo(){
       super.showInfo();
        System.out.println("     Your Saving Account Features: \n     Safty Deposit Box ID  :: " + saftyDepoBoxId +
                            "\n     Safty Deposit Box Key :: " + saftyDepoBoxKey + "\nRate :: " + rate + "%");
    }
}
