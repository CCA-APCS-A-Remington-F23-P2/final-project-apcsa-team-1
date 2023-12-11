// public class Nuzzle extends HitScanAttack{
//     public Nuzzle(){
//         super(3.0, 15);
//         setChainDistance(30);
//         setChainLength(2);
//     }
    
//     @Override 
//     public void cast(Enemy target, Tower tower, List allEnemies, int chain, List chainedEnemies){
//         int closestDistance = Integer.MAX_VALUE;
//         Enemy closestEnemy;
//         for(Enemy enemy: allEnemies){
//             enemyDistance = Math.sqrt((enemy.getXPos() - tower.getXPos())^2 + (enemy.getYPos() - tower.getYPos())^2);
//             if(enemyDistance <= getChainDistance()){
//                 if(closestEnemy == null || enemyDistance < closestDistance){
//                     closestEnemy = enemy;
//                     closestDistance = (int) enemyDistance;
//                 }
//             }

//         }
//     }


// }