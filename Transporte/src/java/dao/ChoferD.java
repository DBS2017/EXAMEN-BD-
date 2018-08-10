package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import modelo.ChoferM;

public class ChoferD extends Dao implements IChofer {

    @Override
    public void guardar(ChoferM chofer) throws Exception {
        try {
           this.conectar();
            String sql = "INSERT INTO CHOFER(NOM_CHOF,APE_CHOF,DIR_CHOF) VALUES (?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, chofer.getNOMBRE());
            ps.setString(2, chofer.getAPELLIDO());
            ps.setString(3, chofer.getDIRECCION());
            ps.executeUpdate();
        } catch (SQLException   e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(ChoferM chofer) throws Exception { 
        try {
            this.conectar();
            String sql="Update CHOFER set NOM_CHOF=?, APE_CHOF=?, DIR_CHOF=? where  COD_CHOF=?";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            ps.setInt(1, chofer.getCODIGO());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(ChoferM chofer) throws Exception {
        try {
            this.conectar();
            String sql ="Delete from CHOFER where COD_CHOF = ? ";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1,chofer.getCODIGO());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public List<ChoferM> listchofer() throws Exception {
        List<ChoferM> listarChofer;
        ResultSet rs;
        try {
            this.conectar();
            String sql="select * from CHOFER";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarChofer = new ArrayList<>();
            ChoferM chofer;
            while (rs.next()) {
                chofer = new ChoferM();
                chofer.setNOMBRE(rs.getString("NOM_CHOF"));
                chofer.setAPELLIDO(rs.getString("APE_CHOF"));
                chofer.setDIRECCION(rs.getString("DIR_CHOF"));
                listarChofer.add(chofer);
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return listarChofer;
        } 
     
       
    
    }

