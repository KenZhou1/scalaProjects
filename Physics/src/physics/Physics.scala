package physics

object Physics {
  def updateWorld(gravity: World, deltaTime: Double): Unit = {

  }

  def computePotentialLocation(x: PhysicalObject, deltaTime: Double): PhysicsVector = {
    var lx = x.location.x + (x.velocity.x * deltaTime)
    var ly = x.location.y + (x.velocity.y * deltaTime)
    var lz = x.location.z + (x.velocity.z * deltaTime)

    if (lz < 0.0) {
      lz = 0.0
    }

    var ans: PhysicsVector = new PhysicsVector(lx, ly, lz)

    ans
  }

  def updateVelocity(phy: PhysicalObject, y: World, deltaTime: Double): Unit = {
    phy.velocity.z = phy.velocity.z - y.gravity * deltaTime

    if (phy.location.z == 0 && phy.velocity.z < 0) {
      phy.velocity.z = 0
    }
  }

  def detectCollision(obj: PhysicalObject, vect: PhysicsVector, bounds: Boundary): Boolean = {
    obj.location.x = obj.location.x + vect.x
    obj.location.y = obj.location.y + vect.y

    var ax = bounds.start.x + bounds.end.x
    var by = bounds.start.y + bounds.end.y
    var cz = bounds.start.z + bounds.end.z


    if (obj.location.x <= ax | obj.location.y <= by)
    {
      true
    }
    else
    {
      false
    }
  }
}
