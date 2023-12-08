// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!
// DEPRECATED--DO NOT USE!

public class ProjectileAttack extends Attack{
    
    public ProjectileAttack(int delay, int dmg){
        super(delay, dmg);
    }
    public ProjectileAttack(int delay, int dmg, Projectile p){
        super(delay, dmg);
        this.proj = p;
    }
    public Projectile getProjectile(){
        return this.proj;
    }
    public void setProjectile(Projectile p){
        this.proj = p;
    }
    
}