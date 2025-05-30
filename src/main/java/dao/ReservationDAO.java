package com.dao;

import com.model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "");
    }

    public void addReservation(Reservation res) throws SQLException {
        String sql = "INSERT INTO Reservations VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, res.getReservationID());
            ps.setString(2, res.getCustomerName());
            ps.setString(3, res.getRoomNumber());
            ps.setDate(4, new java.sql.Date(res.getCheckIn().getTime()));
            ps.setDate(5, new java.sql.Date(res.getCheckOut().getTime()));
            ps.setDouble(6, res.getTotalAmount());
            ps.executeUpdate();
        }
    }

    public void updateReservation(Reservation res) throws SQLException {
        String sql = "UPDATE Reservations SET CustomerName=?, RoomNumber=?, CheckIn=?, CheckOut=?, TotalAmount=? WHERE ReservationID=?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, res.getCustomerName());
            ps.setString(2, res.getRoomNumber());
            ps.setDate(3, new java.sql.Date(res.getCheckIn().getTime()));
            ps.setDate(4, new java.sql.Date(res.getCheckOut().getTime()));
            ps.setDouble(5, res.getTotalAmount());
            ps.setInt(6, res.getReservationID());
            ps.executeUpdate();
        }
    }

    public void deleteReservation(int id) throws SQLException {
        String sql = "DELETE FROM Reservations WHERE ReservationID=?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM Reservations";
        try (Connection con = getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Reservation r = new Reservation();
                r.setReservationID(rs.getInt("ReservationID"));
                r.setCustomerName(rs.getString("CustomerName"));
                r.setRoomNumber(rs.getString("RoomNumber"));
                r.setCheckIn(rs.getDate("CheckIn"));
                r.setCheckOut(rs.getDate("CheckOut"));
                r.setTotalAmount(rs.getDouble("TotalAmount"));
                list.add(r);
            }
        }
        return list;
    }

    public List<Reservation> getReservationsBetweenDates(java.util.Date startDate, java.util.Date endDate) throws SQLException {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM Reservations WHERE CheckIn >= ? AND CheckOut <= ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reservation r = new Reservation();
                    r.setReservationID(rs.getInt("ReservationID"));
                    r.setCustomerName(rs.getString("CustomerName"));
                    r.setRoomNumber(rs.getString("RoomNumber"));
                    r.setCheckIn(rs.getDate("CheckIn"));
                    r.setCheckOut(rs.getDate("CheckOut"));
                    r.setTotalAmount(rs.getDouble("TotalAmount"));
                    list.add(r);
                }
            }
        }
        return list;
    }

    public double getTotalRevenue(java.util.Date startDate, java.util.Date endDate) throws SQLException {
        String sql = "SELECT SUM(TotalAmount) FROM Reservations WHERE CheckIn >= ? AND CheckOut <= ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(1);
                }
            }
        }
        return 0.0;
    }
}
