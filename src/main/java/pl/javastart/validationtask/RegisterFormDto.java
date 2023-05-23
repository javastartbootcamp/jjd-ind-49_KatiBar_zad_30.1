package pl.javastart.validationtask;

import jakarta.validation.constraints.*;

public class RegisterFormDto {

    @NotBlank
    @Size(min = 3)
    private String firstName;
    @NotBlank
    @Size(min = 3)
    private String surname;
    @NotBlank
    private String address;
    @NotBlank
    @Pattern(regexp = "[0-9][0-9]-[0-9][0-9][0-9]",
            message = "{pl.javastart.validationtask.RegisterFormDto.postalCode.pattern.message}")
    private String postalCode;
    @NotBlank
    private String city;
    @NotBlank
    @Email
    private String email;
    @NotBlank(message = "Pole nie może być puste")
    @Size(min=8, message = "Hasło musi mieć co najmniej 8 znaków")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$",
            message = "{pl.javastart.validationtask.RegisterFormDto.password.pattern.message}")
    private String password;
    @AssertTrue
    private boolean termsAgreement;

    public RegisterFormDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTermsAgreement() {
        return termsAgreement;
    }

    public void setTermsAgreement(boolean termsAgreement) {
        this.termsAgreement = termsAgreement;
    }
}
