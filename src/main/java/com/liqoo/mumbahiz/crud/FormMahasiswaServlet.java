package com.liqoo.mumbahiz.crud;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

public class FormMahasiswaServlet extends HttpServlet {
    private MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();

    public void doPost(HttpServletRequest req, HttpServletResponse res){
        try {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNpm(req.getParameter("npm"));
            mahasiswa.setNama(req.getParameter("nama"));
            mahasiswa.setTempatLahir(req.getParameter("tempat_lahir"));
            String strTglLahir = req.getParameter("tanggal_lahir");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");

            mahasiswa.setTanggalLahir(dateFormat.parse(strTglLahir));
            mahasiswa.setJenisKelamin(JenisKelamin.valueOf(req.getParameter("jenis_kelamin").toUpperCase()));
            mahasiswa.setAlamat(req.getParameter("alamat"));

            mahasiswaDAO.simpan(mahasiswa);
            res.sendRedirect("form.html");
        }catch (Exception err){
            err.printStackTrace();
        }
    }
}
