package procatering;

/**
 * Class category contains the information about the several categories.
 *
 * @author Geir Morten Larsen
 */
public class Category {
	private String name;
	private int categoryID = -1;

	/**
	 * Creates an object of type Category. This constructor should be used when getting a category from a database
	 *
	 * @param categoryID The id of the category, as is in the database.
	 * @param name       The name of the category
	 */
	public Category(int categoryID, String name) {
		this.name = name;
		this.categoryID = categoryID;
	}

	/**
	 * Creates an object of type Category. This constructor should be used when putting a category in to the database
	 *
	 * @param name the name of the category.
	 */
	public Category(String name) {
		this.name = name;
	}

	/**
	 * Method gets the name of the category
	 *
	 * @return the category name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the category id from the database
	 *
	 * @return the category id. Returns -1 if the category isn't fetched from the database, but created locally.
	 */
	public int getCategoryID() {
		return categoryID;
	}

	/**
	 * Method returns a string representation of the object.
	 *
	 * @return the name of the category
	 */
	@Override
	public String toString() {
		return this.name;
	}
}

