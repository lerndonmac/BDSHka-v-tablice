package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.tables.ConUsers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Controller {
    Connection con;
     private ObservableList<ConUsers> listUsers = FXCollections.observableArrayList();
     @FXML
    public TableView<ConUsers> tableVusers;
    @FXML
    private TableColumn<ConUsers,String> usersFirstname;
    @FXML
    private TableColumn<ConUsers,String> usersLastName;
    @FXML
    private TableColumn<ConUsers,String> usersEmail;
    @FXML
    private TableColumn<ConUsers,String> usersLogin;

    @FXML
    public TableView tableVCourses;
    @FXML
    private TableColumn coursesTitle;
    @FXML
    private TableColumn coursesLength;
    @FXML
    private TableColumn coursesDescription;

    @FXML
    public TableView tableVTeachers;
    @FXML
    private TableColumn teachersAddr;
    @FXML
    private TableColumn teachersName;
    @FXML
    private TableColumn teachersPhone;

    @FXML
    public TableView tableVLessons;
    @FXML
    private TableColumn lessonsTeacher;
    @FXML
    private TableColumn lessonsCourses;
    @FXML
    private TableColumn lessonsLesson_date;
    @FXML
    private TableColumn lessonsRoom;

    @FXML
    public void initialize() throws ClassNotFoundException {
        con = ConnsectionUtill.myCon();
        initData();
        usersFirstname.setCellValueFactory(new PropertyValueFactory<ConUsers,String>("firstName"));
        usersLastName.setCellValueFactory(new PropertyValueFactory<ConUsers,String>("lastName"));
        usersEmail.setCellValueFactory(new PropertyValueFactory<ConUsers,String>("email"));
        usersLogin.setCellValueFactory(new PropertyValueFactory<ConUsers,String>("login"));
        tableVusers.setItems(listUsers);
    }
    public void initData(){
        String DBFirstName = "";
        String DBLastName = "";
        String DBEmail = "";
        String DBLogin = "";
        String sql = "SELECT * FROM dbwd.users;";
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                DBFirstName = result.getString(2);
                DBLastName = result.getString(3);
                DBEmail = result.getString(4);
                DBLogin = result.getString(5);
                listUsers.add(new ConUsers(result.getString(2),result.getString(3),result.getString(4),result.getString(5)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}