package procatering;

/**
 * Ingredient are made just to create an object to make the program more flexible
 * <dl>
 * <dt>Constructor:</dt>
 * <dd>- int ingredientID,String name</dd>
 * </dl>
 *
 * @author Team 17
 */
public class Ingredient {
	private String name;
	private int ingredientID = -1;

	//TODO Docs
	public Ingredient(String name) {
		this.name = name;
	}

	/**
	 * This methode do not check if for any null values. This is excepted to allready been done.
	 *
	 * @param ingredientID ingredient id
	 * @param name         ingredient name
	 */
	public Ingredient(int ingredientID, String name) {
		this.name = name;
		this.ingredientID = ingredientID;
	}

	/**
	 * //TODO Docs
	 *
	 * @return the String variable name
	 */
	public String getName() {
		return name;
	}

	/**
	 * //TODO Docs
	 *
	 * @return return the int variable ingredientID; Default value equals -1
	 */
	public int getIngredientID() {
		return ingredientID;
	}

	//TODO Docs
	public String toString() {
		return this.name;
	}
}
