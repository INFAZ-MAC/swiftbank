
package lk.ijse.swiftbanksystem.model;



import java.time.LocalDate;

public class Customer {
    private int customerId;
    private String fullName;
    private String nic;
    private LocalDate dob;
    private String phone;
    private String email;
    private String address;

    public Customer() {}

    public Customer(int customerId, String fullName, String nic, LocalDate dob,
                    String phone, String email, String address) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.nic = nic;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}


