package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.entity.Pedido;

public class PedidoDAO {

    public void cadastrar(Connection conn, Pedido p) {
        String sql = "insert into pedidos (email_usuario, cpf_coletor, descricao, horario, estado, id_disponibilidade) values (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getEmail_usuario());
            stmt.setString(2, p.getCpf_coletor());
            stmt.setString(3, p.getDescricao());
            stmt.setTimestamp(4, Timestamp.valueOf(p.getHorario()));
            stmt.setString(5, p.getEstado());
            stmt.setInt(6, p.getId_dispo());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pedido getById(Connection conn, int id) {
        String sql = "select * from pedidos where id = ?";
        Pedido p = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                p = new Pedido(
                    rs.getInt("id"),
                    rs.getInt("id_disponibilidade"),
                    rs.getString("email_usuario"),
                    rs.getString("cpf_coletor"),
                    rs.getString("descricao"),
                    rs.getTimestamp("horario").toLocalDateTime(),
                    rs.getString("estado")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return p;
    }

    public void atualizar(Connection conn, Pedido p) {
        String sql = "update pedidos set email_usuario = ?, cpf_coletor = ?, descricao = ?, horario = ?, estado = ?, id_disponibilidade = ? where id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getEmail_usuario());
            stmt.setString(2, p.getCpf_coletor());
            stmt.setString(3, p.getDescricao());
            stmt.setTimestamp(4, Timestamp.valueOf(p.getHorario()));
            stmt.setString(5, p.getEstado());
            stmt.setInt(6, p.getId_dispo());
            stmt.setInt(7, p.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pedido> getAllPendentes(Connection conn) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "select * from pedidos where estado = 'pendente'";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                pedidos.add(new Pedido(
                    rs.getInt("id"),
                    rs.getInt("id_disponibilidade"),
                    rs.getString("email_usuario"),
                    rs.getString("cpf_coletor"),
                    rs.getString("descricao"),
                    rs.getTimestamp("horario").toLocalDateTime(),
                    rs.getString("estado")
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pedidos;
    }

    public List<Pedido> listarPorColetorEEstado(Connection conn, String estado, String cpfColetor) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "select * from pedidos where cpf_coletor = ? and estado = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpfColetor);
            stmt.setString(2, estado);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                pedidos.add(new Pedido(
                    rs.getInt("id"),
                    rs.getInt("id_disponibilidade"),
                    rs.getString("email_usuario"),
                    rs.getString("cpf_coletor"),
                    rs.getString("descricao"),
                    rs.getTimestamp("horario").toLocalDateTime(),
                    rs.getString("estado")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pedidos;
    }
}
