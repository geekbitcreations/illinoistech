@Entity
@Table(name = "LOGINTBL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logintbl.findByUsernameAndPassword", 
        query = "SELECT l FROM Logintbl l where l.username = :username "
        + "and l.password= :password") 
    })
public class Logintbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PASSWORD")
    private String password;
    ... setter and getter methods