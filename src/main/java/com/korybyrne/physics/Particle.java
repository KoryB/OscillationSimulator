import org.apache.commmons.math3.geometry.euclidean.threed;

public class Particle {
	private double radius;
	private double inverseMass;
	
	private Vector3D position;
	private Vector3D velocity;
	private Vector3D acceleration;
	
	private Vector3D forceAccum;
	
	public Particle(double radius, double mass, Vector3D position, Vector3D velocity) {
		this.radius = radius;
		this.inverseMass = 1 / mass;
		
		this.position = position;
		this.velocity = velocity;
		
		this.acceleration = Vector3D.ZERO;
		this.forceAccum   = Vector3D.ZERO;
	}
	
	public void integrate(double duration) {
		//TODO:kb add runge-kutta 4 integration
		
		Vector3D resultingAcceleration = acceleration.add(inverseMass, forceAccum);
		
		position = position.add(duration, velocity);
		velocity = velocity.add(duration, resultingAcceleration);
		
		clearAccumulator();
	}
	
	private clearAccumulator() {
		this.forceAccum = Vector3D.ZERO;
	}
	
	
}
