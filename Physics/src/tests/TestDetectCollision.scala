package tests
import org.scalatest._
import physics._

class TestDetectCollision extends FunSuite
{
  test("Velocity Update is being checked")
  {
    var location1 = new PhysicsVector(100, 100.0, 100.0)
    var velocity1 = new PhysicsVector(100.0, 100.0, 100.0)
    var vector = new PhysicsVector(100.0, 100.0, 100.0)
    var start1 = new PhysicsVector(100, 100.0, 100.0)
    var end1 = new PhysicsVector(100.0, 100.0, 100.0)
    val object1= new PhysicalObject(location1,velocity1)
    val base1 = new Boundary(start1,end1)


    assert(Physics.detectCollision(object1, vector, base1) == true, "1")


    var location2 = new PhysicsVector(10, 10.0, 100.0)
    var velocity2 = new PhysicsVector(10.0, 10.0, 0.0)
    var vector1 = new PhysicsVector(100.0, 100.0, 100.0)
    var start2 = new PhysicsVector(0, 0.0, 0.0)
    var end2 = new PhysicsVector(0.0, 0.0, 100.0)
    val object2= new PhysicalObject(location1,velocity1)
    val base2 = new Boundary(start1,end1)


    assert(Physics.detectCollision(object2, vector1, base2) == false, "2")


  }
}
