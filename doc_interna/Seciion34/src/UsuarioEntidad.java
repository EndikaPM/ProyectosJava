public class UsuarioEntidad {
    private Long id;
    private static Long idAcumul = 0L;
    private String usuername;
    private String password;
    private String email;

    public UsuarioEntidad() {}
    public UsuarioEntidad(String usuername, String password, String email) {
        this.id = idAcumul ++;
        this.usuername = usuername;
        this.password = password;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsuername() {
        return usuername;
    }

    public void setUsuername(String usuername) {
        this.usuername = usuername;
    }
    @Override
    public String toString() {
        return id + " | " + usuername + " | " + password + " | " + email;
    }
}
