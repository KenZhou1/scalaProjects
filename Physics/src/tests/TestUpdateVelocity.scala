package tests
import org.scalatest._
import physics._

class TestUpdateVelocity extends FunSuite
{
  test("Velocity Update is being checked")
  {
    val location5 = new PhysicsVector(100, 100.0, 100.0)
    var velocity5 = new PhysicsVector(100.0, 100.0, 100.0)
    val gravity5 = new World(9.8)
    val object5 = new PhysicalObject(location5, velocity5)

    Physics.updateVelocity(object5,gravity5,2.0)

    assert(object5.velocity.z == 80.4, "4")

    var location6 = new PhysicsVector(100, 100.0, 0.0)
    var velocity6 = new PhysicsVector(100.0, 100.0, -40.0)
    var gravity6 = new World(9.8)
    var object6 = new PhysicalObject(location6, velocity6)

    Physics.updateVelocity(object6,gravity6,2)

    assert(object6.velocity.z == 0, "5")


    val location11 = new PhysicsVector(100, 100.0, 0.0)
    var velocity11 = new PhysicsVector(100.0, 100.0, 30.0)
    val gravity11 = new World(3)
    var object11 = new PhysicalObject(location11, velocity11)

    Physics.updateVelocity(object11,gravity11,3)

    assert(object11.velocity.z == 21, "9")

  }
}
