# Hotel-Management-System

Project Purpose:                      
To manage hotel reservations, room availability, and billing. Modules include adding reservations, updating bookings, cancelling reservations, and viewing current occupancy. Reports include rooms
booked in a date range, revenue generated, and reservations by customer.                        

___

Modules & Functionalities:                                           
ReservationAdd: Book new reservations                         
ReservationUpdate: Change reservation details                           
ReservationDelete: Cancel reservations                               
ReservationDisplay: View all reservations    

Reports:                                     
Reservations in a date range                                      
Rooms booked most frequently                                       
Total revenue over a period                                

_____
 
📋 Prerequisites                                        

Before running this application, make sure you have the following installed:                                           
*. Java Development Kit (JDK) 8 or higher                                                      
*. Apache Tomcat 9.0 or higher                                           
*. MySQL Server 5.7 or XAMP Server                                                    
*. MySQL JDBC Driver (mysql-connector-java)                                                       
*. IDE: Eclipse (J2EE), IntelliJ IDEA, or any Java IDE                                     
*. Web Browser: Chrome, Firefox, or Edge                                              

____

Database Structure:                                       
CREATE TABLE Reservations (                                             
ReservationID INT PRIMARY KEY,                                        
CustomerName VARCHAR(100),                                                      
RoomNumber VARCHAR(10),                                            
CheckIn DATE,                                                 
CheckOut DATE,                                                                 
TotalAmount DECIMAL(10,2)                                                      
);                                                              

______

🛠️Project Structure:                                     
HotelWebApp/                                                  
├── WebContent/                                                       
│ ├── index.jsp                                                                          
│ ├── reservationadd.jsp                                                                   
│ ├── reservationupdate.jsp                                                                              
│ ├── reservationdelete.jsp                                                                    
│ ├── reservationdisplay.jsp                                                       
│ ├── reports.jsp                                                            
│ ├── report_form.jsp                                              
│ └── report_result.jsp                                                              
├── src/                                                  
│ ├── com/                                                                   
│ ├── dao/                                                                         
│ │ └── ReservationDAO.java                                                         
│ ├── model/                                                
│ │ └── Reservation.java                                                             
│ └── servlet/                                                                                     
│ ├── AddReservationServlet.java                                          
│ ├── UpdateReservationServlet.java                                                                     
│ ├── DeleteReservationServlet.java                                                           
│ ├── DisplayReservationsServlet.java                                                       
│ ├── ReportServlet.java                                                            
│ └── ReportCriteriaServlet.java                                                         
└── WEB-INF/web.xml                                                

____

🖼️ Screenshots

![image alt]()
