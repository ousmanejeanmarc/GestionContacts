/**
 * 
 */
package entities;

/**
 * @author ousmane
 *
 */
public class Entreprise extends Contact{
	
	private long NumSiret ;

	/**
	 * @return the numSiret
	 */
	public long getNumSiret() {
		return NumSiret;
	}

	/**
	 * @param numSiret the numSiret to set
	 */
	public void setNumSiret(long numSiret) {
		NumSiret = numSiret;
	}
}
