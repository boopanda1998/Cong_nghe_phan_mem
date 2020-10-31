java
java.sql.DriverManager
dùng để load các driver và tạo Connection đến cơ sở dữ liệu
java.sql.Connection
thể hiện một Connection đến database và cho phép tạo các statement

java.sql.Sratement gắn kết với một 
Connection đến cơ sở dữ liệu cho phép gửi đến database các câu lệnh SQL

java.sql.callableStatement tương tự như statement nhưng áp dụng cho store procedures
java.sql.DatabaseMetaData
 

 PreparedStatemnent tương tự như statement nhưng áp dụng cho precompiled SQL
 ResultSet cho phép truy xuất các row của các câu lệnh sql đã thực thi

 java.sql.ResultSetMetaData : cung cấp các thông tin như kiểu dự liệu và các thuộc tính trong ResultSet
 java.sql.DatabaseMetaData cung cấp các thông tin của cơ sở dữ liệu kết nối


 các bước thực hiện cơ bản sử dụng JDBC
 1 đăng ký DriverManager
 	- có 2 cách dùng
 	Class.forName("com.microsoft.sqlsever.jdbc.SQLseverDriver");
 	DriverManager.registerDriver(new SQLseverDriver);
 2 thiết lập Connection
 Connection connect = DriverManager.getConnection(url,username,pass);
 URL:jdbc:<subprotocol>:<subname>
 username: dung để đăng nhập vào database nếu có
 Password dùng để đăng nhập vào database nếu có

 3 tạo statement
 Statement stmt = connect.createStatement(); 
 gắn kết với một connection đến cơ sở dữ liệu cho phép gửi đến database các câu lện SQL
 4 thực thi SQL
 ResultSet rs = stmt.execute(sql);
 select
 int n = stmt.executeUpdate(sql);
 	Insert
	Update
	Delete
	Create

 5 xử lý ResultSet
 6 đóng Connection

 //Demo
public class MySQLConnect{
 	String Host     ="";//thông tin host của database sever mình kết nối tới
 	String Username ="";//Thông tin tên đăng nhập của database sever
 	String Password ="";//thông tin mật khẩu của database sever
 	String Database ="";//Tên database muốn connect tới
 	
 	Connection connect  =null;// khởi tạo hàm connection bằng null
 	Statement statement =null;// khơi tạo hàm Statement để thực thi
 	ResultSet result    =null;// khơi tạo hàm resultset để chứa dữ liệu
        
        //Hàm khởi tạo và truyền thông tin của database
        public MySQLConnect(String Host,String Username,String Password,String Database) {
            this.Database = Database;
            this.Host     = Host;
            this.Password = Password;
            this.Username = Username;
        }
        
        //Hàm kiểm tra xem Driver connect MySQL đã sẵn sàng hay chưa.
        protected  void driverTest() throws Exception{
            //Kiểm tra Classname.
            try{
                
                Class.forName("com.mysql.jdbc.Driver");
            } 
            //nếu chưa tìm thấy thì ném lỗi ra ngoài.
            catch(java.lang.ClassNotFoundException e){
                throw new Exception("MySQL JDBC Driver not found");
            }
        }
        //Hàm lấy connection
        protected Connection getConnect()throws Exception{
            if(this.connect == null)
                //Kiểm tra driver
                driverTest();
                //tạo URL kết nối đến database sever
                String url = "jdbc:mysql://"+this.Host+":3306/"+this.Database;
                //tạo connection thông qua url
                try{
                    this.connect = DriverManager.getConnection(url, this.Username, this.Password);
                }
                //Nếu không thành công ném lỗi ra ngoài
                catch(Exception e){
                    throw new Exception("Không thể kết nối đến dataBase Server");
                    
                }
                //trả connection ra ngoài
             return this.connect ;
            
        }
        // tạo Statement để thực hiện câu Query
        protected Statement getStatement() throws Exception{
            //Kiểm tra statement nếu = null hoặc đã đóng.
            if(this.statement == null ||this.statement.isClosed())
            //khởi tạo một statement mới.
            this.statement = this.getConnect().createStatement();
        	return this.statement;
        }
        //Hàm thực thi câu lệnh Select lấy dữ liêu từ CSDL
        public ResultSet excuteQuery(String Query) throws Exception{
        	//Thực thi câu lệnh
        	try{
        		this.result = getStatement().excuteQuery(Query);
        	}
        	//Nếu không thành công ném lỗi ra ngoài
        	catch (Exception e) {
        		throw new Exception("Error: "+ e.getMessage()+" - "+Query);
        	}
        	//trả kết quả ra ngoài.
        	return this.result;
        }
        //Thực thi các câu lệnh Insert, Update, Delete
        public int executeUpdate(String Query) throws Exception{
        	//Khai báo biến int lưu trữ kết qua tình trạng thực thu câu lệnh
        	int res = Integer.MIN_VALUE;
        	try{
        	//Thực thi câu lệnh.
        		res = getStatement().executeUpdate(Query);
        	}
        	//Nếu không thành công ném lỗi ra ngoài.
        	catch(Exception e){
        		throw new Exception("Error: " + e.getMessage()+ "_"+Query);
        	finally{
        	//Đóng kết nối
        		this.Close();
        		}
        	}
        	//Trả kết quả ra ngoài.
        	return res;
        }
        public void Close() throws SQLException{
        	//Nếu Result chưa đóng.Đóng Result
        	if(this.result != null && !this.result.isClosed()){
        		this.result.close();
        		this.result = null;
        	}
        	//Nếu Statement chưa đóng.Đóng Statement
        	if(this.statement != null && !this.statement.isClosed()){
        		this.statement.close();
        		this.statement = null;
        	}
        	//Nếu connection chưa đóng.Đóng connection
        	if(this.connect != null && !this.connect.isClosed()){
        		this.connect.close();
        		this.connect = null;
        	}
        }
    }