package org.nikhil.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.CascadeType;






import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.Type;

@Entity  //(name="USER_DETAILS")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="UserDetails.byId", query="from UserDetails where id = ?" )
//@NamedNativeQuery(name="UserDetails.byName", query="select * from USER_DETAILS where name = ?", resultClass=UserDetails.class)
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_Id")
	private int id;
	
	//@Transient  -  ignore field ,  @Basic   -make field as default
	private String name;
//	@OneToOne(mappedBy="user")
//	@JoinColumn(name="Vehicle_Id")
//	@JoinTable(name="User_Vehicle" ,joinColumns=@JoinColumn(name="User_Id"),
//									inverseJoinColumns=@JoinColumn(name="User_Vehicle"))
//	@ManyToMany
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
//	private Vehicle vehicle;
	
//	private String address;
//	@Temporal(value = TemporalType.DATE)
//	private Date joinedDate;
//	@Lob //Lob on String for file,  on byte[] for image,audio,video
//	private String discription;
/*	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="pincode", column=@Column(name="HOME_PINCODE_NAME")),

	})
	private Address homeAddress;*/
	
public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	/*public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}*/
	//	private Address companyAddress;
//	@ElementCollection(fetch=FetchType.EAGER)
//	@JoinTable(name="USER_ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))
//	private Set<Address> listOfAddress = new HashSet<Address>();
//	@GenericGenerator(name="hilo-gen", strategy="hilo")
//	@CollectionId(columns={@Column(name="ADDRESS_ID")}, generator="hilo-gen", type=@Type(type="Long"))
/*	private Collection<Address> listOfAddress = new ArrayList<Address>();
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}*/
	/*public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	*/
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	/*	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public Address getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}
	*/
	/*public Set<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}*/

}
