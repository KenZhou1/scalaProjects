package towers.model.game_objects

import play.api.libs.json.{JsValue, Json}
import towers.model.genetics.genes.Gene
import towers.model.physics.PhysicsVector

import scala.math.sqrt

class DodgeBallTower(val x: Int, val y: Int) extends GameObject {

  // The height at which projectiles are fired
  val height = 3.0

  // Towers can only fire at players closer than this distance from the tower
  val sightRange = 5.0

  // The magnitude of the velocity at which projectiles are fired
  val projectileVelocity = 5.0


  def fire(jsonGameState: String): List[Projectile] = {
    // TODO: Objective 2
    val parse : JsValue = Json.parse(jsonGameState)
    val players : List[JsValue] = (parse \ "players").as[List[JsValue]]
    var minimum : Double = 5.1
    var closestPlayer : PhysicsVector = new PhysicsVector(0,0,0)
    val tower : PhysicsVector = new PhysicsVector(x + .5, y + .5, height)

    for(player <- players)
    {
      var play : PhysicsVector = new PhysicsVector(player("x").as[Double], player("y").as[Double], 0.0)


      var distance : Double = sqrt(Math.pow(play.x - tower.x,2) + Math.pow(play.y - tower.y,2))

      if(distance <= sightRange)
      {
        if(distance < minimum)
        {
          minimum = distance
          closestPlayer = play
        }
      }
    }
    var playerX = (tower.x - closestPlayer.x) * -1
    var playerY = (tower.y - closestPlayer.y) * -1
    var normalX = projectileVelocity * playerX/math.sqrt(math.pow(tower.x - closestPlayer.x,2) + math.pow(tower.x - closestPlayer.x,2))
    var normalY = projectileVelocity * playerY/math.sqrt(math.pow(tower.y - closestPlayer.y,2) + math.pow(tower.y - closestPlayer.y,2))


    //val newx : PhysicsVector = new PhysicsVector(playerX, playerY)
    //newx.normal2d()
    var velocity = new PhysicsVector(normalX, normalY)
    var projectile : Projectile = new Projectile(tower, velocity)

    if(minimum == 5.1) {
      List()
    }
    else {
      List(projectile)
    }
  }


  def aimFire(jsonGameState: String): List[Projectile] = {
    // TODO: Bonus Objective
    List()
  }


  // Suggested Genetic Algorithm setup
  def getFitnessFunction(targetPlayer: Player): PhysicsVector => Double = {
    null
  }

  def vectorIncubator(genes: List[Gene]): PhysicsVector = {
    null
  }

}
