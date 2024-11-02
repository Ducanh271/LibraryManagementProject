-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 02, 2024 at 06:52 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quan_ly_thu_vien`
--

-- --------------------------------------------------------

--
-- Table structure for table `bansaosach`
--

CREATE TABLE `bansaosach` (
  `maSach` varchar(45) NOT NULL,
  `maBanSao` varchar(10) NOT NULL,
  `loaiBanSao` int(11) NOT NULL,
  `gia` int(11) NOT NULL,
  `trangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `bansaosach`
--

INSERT INTO `bansaosach` (`maSach`, `maBanSao`, `loaiBanSao`, `gia`, `trangThai`) VALUES
('IT1000', 'IT1000-01', 1, 50000, 0),
('IT1000', 'IT1000-02', 1, 50000, 0),
('IT1000', 'IT1000-03', 1, 50000, 0),
('IT1000', 'IT1000-04', 1, 50000, 0),
('IT1000', 'IT1000-05', 1, 50000, 0),
('IT1000', 'IT1000-06', 1, 50000, 0),
('IT1000', 'IT1000-07', 1, 50000, 0),
('IT1000', 'IT1000-08', 0, 60000, 0),
('IT1000', 'IT1000-09', 0, 60000, 0),
('IT1000', 'IT1000-10', 0, 60000, 0),
('IT1001', 'IT1001-01', 1, 70000, 0),
('IT1001', 'IT1001-02', 0, 30000, 0),
('IT6666', 'IT6666-01', 1, 56000, 0),
('IT6666', 'IT6666-02', 1, 56000, 0),
('IT6666', 'IT6666-03', 1, 56000, 0),
('IT7777', 'IT7777-01', 1, 56789, 0),
('IT7777', 'IT7777-02', 1, 56789, 0),
('IT7777', 'IT7777-03', 1, 56789, 0),
('IT7777', 'IT7777-04', 1, 56789, 0),
('IT7777', 'IT7777-05', 1, 56789, 0),
('QS1111', 'QS1111-01', 1, 40000, 1),
('QS1111', 'QS1111-02', 1, 40000, 0),
('QS1111', 'QS1111-03', 0, 40000, 0),
('TH1000', 'TH1000-01', 1, 75000, 0),
('TS9999', 'TS9999-01', 1, 90000, 0),
('TS9999', 'TS9999-02', 1, 90000, 0),
('TS9999', 'TS9999-03', 1, 90000, 0),
('TS9999', 'TS9999-04', 0, 90000, 0),
('TS9999', 'TS9999-05', 0, 90000, 0),
('VH1000', 'VH1000-01', 1, 30000, 0),
('VH1001', 'VH1001-01', 1, 40000, 0),
('VN1000', 'VN1000-01', 1, 40000, 0),
('VN1000', 'VN1000-02', 1, 40000, 0),
('VN1000', 'VN1000-03', 0, 40000, 0),
('VN1000', 'VN1000-04', 0, 30000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `chitietmuonsach`
--

CREATE TABLE `chitietmuonsach` (
  `maThongTinMuonSach` varchar(100) NOT NULL,
  `maBanSaoSach` varchar(10) NOT NULL,
  `trangThai` int(11) DEFAULT NULL,
  `ngayMuon` varchar(45) DEFAULT NULL,
  `ngayTra` varchar(45) DEFAULT NULL,
  `tienPhat` int(11) DEFAULT NULL,
  `lyDoPhat` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `chitietmuonsach`
--

INSERT INTO `chitietmuonsach` (`maThongTinMuonSach`, `maBanSaoSach`, `trangThai`, `ngayMuon`, `ngayTra`, `tienPhat`, `lyDoPhat`) VALUES
('TQB0001', 'QS1111-01', 2, '16/12/2017', '20/12/2017', 10000, 'làm rách sách'),
('TQB0002', 'IT1000-01', 1, '23/11/2017', '02/12/2017', 0, ''),
('TQB0002', 'IT1001-01', 1, '23/11/2017', '02/12/2017', 0, ''),
('TQB0004', 'IT1001-01', 2, '02/12/2017', '02/12/2017', 30000, ''),
('TQB0005', 'QS1111-01', 2, '02/12/2017', '02/12/2017', 0, ''),
('TQB0006', 'IT7777-01', 2, '02/12/2017', '02/12/2017', 0, ''),
('TQB0007', 'VH1001-01', 2, '02/12/2017', '02/12/2017', 0, ''),
('TQB0008', 'IT1000-01', 2, '03/12/2017', '03/12/2017', 0, ''),
('TQB0009', 'IT6666-01', 2, '03/12/2017', '03/12/2017', 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `chitiettacgia`
--

CREATE TABLE `chitiettacgia` (
  `maSach` varchar(6) NOT NULL,
  `maTacGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `chitiettacgia`
--

INSERT INTO `chitiettacgia` (`maSach`, `maTacGia`) VALUES
('IT1000', 12),
('IT1001', 1),
('IT6666', 4),
('IT6666', 13),
('IT7777', 2),
('IT7777', 14),
('QS1111', 2),
('TH1000', 12),
('TS9999', 1),
('TS9999', 2),
('TS9999', 12),
('VH1000', 1),
('VH1001', 2),
('VN1000', 12);

-- --------------------------------------------------------

--
-- Table structure for table `nguoimuon`
--

CREATE TABLE `nguoimuon` (
  `maNM` varchar(10) NOT NULL,
  `tenNM` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `nguoimuon`
--

INSERT INTO `nguoimuon` (`maNM`, `tenNM`, `email`) VALUES
('CT030201', 'test6', 'test6@example.com'),
('CT050423', 'test5', 'test5@example.com'),
('CT060201', 'test4', 'test4@example.com'),
('CT060401', 'test3', 'test3@example.com'),
('CT060402', 'Nguyễn Đức Anh', 'CT060402@actvn.edu.vn'),
('CT060414', 'Lệnh Quang Hưng', 'test1@example.com'),
('CT060424', 'Nguyễn Doãn Minh', 'test2@example.com'),
('GV090807', 'test7', 'test7@example.com'),
('GV122222', 'test8', 'test8@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `nhaphathanh`
--

CREATE TABLE `nhaphathanh` (
  `maNhaPhatHanh` int(11) NOT NULL,
  `tenNhaPhatHanh` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `nhaphathanh`
--

INSERT INTO `nhaphathanh` (`maNhaPhatHanh`, `tenNhaPhatHanh`) VALUES
(1, 'Nhà xuất bản Đại học Bách Khoa Hà Nội'),
(2, 'Nhà xuất bản Xây Dựng '),
(3, 'Nhà xuất bản giáo dục'),
(4, 'Nhà xuất bản Đại học KTQD'),
(5, 'Nhà xuất bản Kim Đồng'),
(6, 'Nhà xuất bản Tuổi trẻ'),
(7, 'Nhà xuất bản Đại học Quốc gia Hà Nội'),
(8, 'Nhà xuất bản Đại học Quốc gia TPHCM'),
(9, 'Nhà xuất bản Lao động'),
(10, 'Nhà xuất bản Chính trị Quốc gia - Sự thật');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `maSach` varchar(6) NOT NULL,
  `tenSach` varchar(45) NOT NULL,
  `theLoai` varchar(30) NOT NULL,
  `maNhaPhatHanh` int(11) NOT NULL,
  `soLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`maSach`, `tenSach`, `theLoai`, `maNhaPhatHanh`, `soLuong`) VALUES
('IT1000', 'Toán Rời Rạc', 'Giáo Khoa', 1, 10),
('IT1001', 'Cấu Trúc Dữ Liệu và Giải thuật', 'Giáo Khoa', 1, 15),
('IT6666', 'Test', 'Thử Nghiệm', 1, 5),
('IT7777', 'Wqwqe', 'Thử Nghiệm', 1, 7),
('QS1111', 'Test', 'Thử Nghiệm', 1, 3),
('TH1000', 'Đại Số Tuyến Tính', 'Giáo Khoa', 2, 8),
('TS9999', 'Sách Test', 'Thử Nghiệm', 1, 2),
('VH1000', 'Đắc Nhân Tâm', 'Văn Học', 6, 12),
('VH1001', 'Nhà Giả Kim', 'Văn Học', 5, 14),
('VN1000', 'Tên Là Gì', 'Văn Học', 1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `maTacGia` int(11) NOT NULL,
  `tenTacGia` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`maTacGia`, `tenTacGia`) VALUES
(1, 'Nguyễn Đức Nghĩa'),
(2, 'Huỳnh Quyết Thắng'),
(3, 'Nguyễn Viết Đông'),
(4, 'Đậu Thế Cấp'),
(5, 'Võ Khắc Thường'),
(6, 'Paulo Coelho'),
(7, 'Dale Carnegie'),
(8, 'Andy Andrews'),
(9, 'Tony Buổi Sáng'),
(10, 'Ngô Tất Tố'),
(11, 'Nguyễn Du'),
(12, 'Trần Sơn Tùng'),
(13, 'ád'),
(14, 'qewqe');

-- --------------------------------------------------------

--
-- Table structure for table `thongtinmuontrasach`
--

CREATE TABLE `thongtinmuontrasach` (
  `maThongTinMuonTraSach` varchar(100) NOT NULL,
  `ngayMuon` varchar(10) NOT NULL,
  `hanTra` varchar(10) DEFAULT NULL,
  `trangThai` varchar(15) DEFAULT NULL,
  `maNM` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `thongtinmuontrasach`
--

INSERT INTO `thongtinmuontrasach` (`maThongTinMuonTraSach`, `ngayMuon`, `hanTra`, `trangThai`, `maNM`) VALUES
('TQB0001', '15/12/2023', '21/12/2023', '2', 'CT030201'),
('TQB0002', '16/12/2023', '22/12/2023', '1', 'CT050423'),
('TQB0003', '17/12/2023', '23/12/2023', '2', 'CT060201'),
('TQB0004', '18/12/2023', '24/12/2023', '1', 'CT060401'),
('TQB0005', '19/12/2023', '25/12/2023', '1', 'CT060402'),
('TQB0006', '20/12/2023', '26/12/2023', '2', 'CT060414'),
('TQB0007', '21/12/2023', '27/12/2023', '1', 'CT060424'),
('TQB0008', '22/12/2023', '28/12/2023', '1', 'GV090807'),
('TQB0009', '23/12/2023', '29/12/2023', '2', 'GV122222');

-- --------------------------------------------------------

--
-- Table structure for table `thuthu`
--

CREATE TABLE `thuthu` (
  `taiKhoan` varchar(20) NOT NULL,
  `matKhau` varchar(255) NOT NULL,
  `maNV` int(11) DEFAULT NULL,
  `hoTenNV` varchar(50) DEFAULT NULL,
  `SDT` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `thuthu`
--

INSERT INTO `thuthu` (`taiKhoan`, `matKhau`, `maNV`, `hoTenNV`, `SDT`) VALUES
('ad', '1', 100, 'Duc Anh', '0947813710'),
('admin', 'password123', 101, 'Nguyen Van A', '0123456789'),
('user1', 'mypassword', 102, 'Tran Thi B', '0987654321'),
('user2', 'pass2024', 103, 'Le Van C', '0112233445');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bansaosach`
--
ALTER TABLE `bansaosach`
  ADD PRIMARY KEY (`maBanSao`),
  ADD KEY `maSach_idx` (`maSach`);

--
-- Indexes for table `chitietmuonsach`
--
ALTER TABLE `chitietmuonsach`
  ADD PRIMARY KEY (`maThongTinMuonSach`,`maBanSaoSach`),
  ADD KEY `key_ban_sao_idx` (`maBanSaoSach`);

--
-- Indexes for table `chitiettacgia`
--
ALTER TABLE `chitiettacgia`
  ADD PRIMARY KEY (`maSach`,`maTacGia`),
  ADD KEY `fk_Sach_has_TacGia_TacGia1_idx` (`maTacGia`),
  ADD KEY `fk_Sach_has_TacGia_Sach1_idx` (`maSach`);

--
-- Indexes for table `nguoimuon`
--
ALTER TABLE `nguoimuon`
  ADD PRIMARY KEY (`maNM`);

--
-- Indexes for table `nhaphathanh`
--
ALTER TABLE `nhaphathanh`
  ADD PRIMARY KEY (`maNhaPhatHanh`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`maSach`),
  ADD KEY `maNhaPhatHanh` (`maNhaPhatHanh`);

--
-- Indexes for table `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`maTacGia`);

--
-- Indexes for table `thongtinmuontrasach`
--
ALTER TABLE `thongtinmuontrasach`
  ADD PRIMARY KEY (`maThongTinMuonTraSach`),
  ADD KEY `key_ma_nm_idx` (`maNM`);

--
-- Indexes for table `thuthu`
--
ALTER TABLE `thuthu`
  ADD PRIMARY KEY (`taiKhoan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nhaphathanh`
--
ALTER TABLE `nhaphathanh`
  MODIFY `maNhaPhatHanh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `maTacGia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bansaosach`
--
ALTER TABLE `bansaosach`
  ADD CONSTRAINT `maSach` FOREIGN KEY (`maSach`) REFERENCES `sach` (`maSach`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `chitietmuonsach`
--
ALTER TABLE `chitietmuonsach`
  ADD CONSTRAINT `key_ban_sao` FOREIGN KEY (`maBanSaoSach`) REFERENCES `bansaosach` (`maBanSao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `key_thong_tin_muon` FOREIGN KEY (`maThongTinMuonSach`) REFERENCES `thongtinmuontrasach` (`maThongTinMuonTraSach`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `chitiettacgia`
--
ALTER TABLE `chitiettacgia`
  ADD CONSTRAINT `fk_Sach_has_TacGia_Sach1` FOREIGN KEY (`maSach`) REFERENCES `sach` (`maSach`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Sach_has_TacGia_TacGia1` FOREIGN KEY (`maTacGia`) REFERENCES `tacgia` (`maTacGia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `maNhaPhatHanh` FOREIGN KEY (`maNhaPhatHanh`) REFERENCES `nhaphathanh` (`maNhaPhatHanh`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `thongtinmuontrasach`
--
ALTER TABLE `thongtinmuontrasach`
  ADD CONSTRAINT `key_ma_nm` FOREIGN KEY (`maNM`) REFERENCES `nguoimuon` (`maNM`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
