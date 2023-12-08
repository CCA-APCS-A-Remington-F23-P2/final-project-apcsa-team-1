public class MegaWaterfall extends HitScanAttack{
    public MegaWaterfall(){
        super(500, 80);
        setStunDuration(300);
    }
    @Override
    public void cast(Tower t, List enemyList){
        int xPos = t.getXPos();
        int yPos = t.getYPos();
        for(Enemy e: enemyList){
            int eX = e.getXPos();
            int eY = e.getYPos();
            int distance = Math.sqrt((xPos - eX)^2 + (yPos - eY)^2);
            if(distance < getSplashRadius()){
                e.takeDamage(getAttackDamage());
                e.setStunCounter(getStunDuration());
            }
        }
    }
}
