
public class Pizza {
  private int size;
  private boolean cheese;
  private boolean pepperoni;
  private boolean bacon;
 
  public static class Builder {
    //required
    private final int size;
 
    //optional
    private boolean cheese = false;
    private boolean pepperoni = false;
    private boolean bacon = false;
 
    public Builder(int size) {
      this.size = size;
    }
 
    public Builder addCheese() {
      cheese = true;
      return this;
    }
 
    public Builder addPepperoni() {
      pepperoni = true;
      return this;
    }
 
    public Builder addBacon() {
      bacon = true;
      return this;
    }
 
    public Pizza build() {
      return new Pizza(this);
    }
  }
 
  private Pizza(Builder builder) {
    size = builder.size;
    cheese = builder.cheese;
    pepperoni = builder.pepperoni;
    bacon = builder.bacon;
  }

	@Override
	public String toString() {
		return "Pizza [size=" + size + ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", bacon=" + bacon + "]";
	}  
}
