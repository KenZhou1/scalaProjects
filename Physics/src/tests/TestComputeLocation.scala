package tests
import org.scalatest._
import physics._

class TestComputeLocation extends FunSuite
{
    test("Location is being checked")
    {
        val location1 = new PhysicsVector(10.0, 20.0, 30.0)
        val velocity1 = new PhysicsVector(0.0, 0.0, 0.0)
        val object1 = new PhysicalObject(location1, velocity1)

        assert(Physics.computePotentialLocation(object1,1.0).x == 10.0, "1x")
        assert(Physics.computePotentialLocation(object1,1.0).y == 20.0, "1y")
        assert(Physics.computePotentialLocation(object1,1.0).z == 30.0,"1z")

        val location2 = new PhysicsVector(1.0, 2.0, 3.0)
        val velocity2 = new PhysicsVector(3.0, 2.0, 1.0)
        val object2 = new PhysicalObject(location2, velocity2)

        assert(Physics.computePotentialLocation(object2,2.0).x == 7.0, "2x")
        assert(Physics.computePotentialLocation(object2,2.0).y == 6.0, "2y")
        assert(Physics.computePotentialLocation(object2,2.0).z == 5.0, "2z")

        val location3 = new PhysicsVector(0.0, 0.0, -1.0)
        val velocity3 = new PhysicsVector(0.0, 0.0, -1.0)
        val object3 = new PhysicalObject(location3, velocity3)

        assert(Physics.computePotentialLocation(object3,1.0).x == 0.0, "3x")
        assert(Physics.computePotentialLocation(object3,1.0).y == 0.0, "3y")
        assert(Physics.computePotentialLocation(object3,1.0).z == 0.0, "3z")
    }
}
