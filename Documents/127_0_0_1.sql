-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 04, 2020 lúc 11:59 PM
-- Phiên bản máy phục vụ: 10.4.13-MariaDB
-- Phiên bản PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cnpm`
--
CREATE DATABASE IF NOT EXISTS `cnpm` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cnpm`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKhachHang` varchar(10) NOT NULL,
  `Ho` varchar(10) NOT NULL,
  `Ten` varchar(10) NOT NULL,
  `SDT` varchar(10) NOT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKhachHang`, `Ho`, `Ten`, `SDT`, `enable`) VALUES
('001', 'a', 'a', '0988897467', 1),
('002', '123', '123', '0988887467', 1),
('003', 'gfd', 'fsdf', '0988888888', 1),
('004', 'vhg', 'khkn', '07972', 1),
('005', '', 'kn', '9', 1),
('006', 'ghg', 'knfg', '0954', 1),
('007', 'hồ', 'vhghkn', '09', 1),
('008', '', 'knfg', '09', 1);
--
-- Cơ sở dữ liệu: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin DEFAULT NULL,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Đang đổ dữ liệu cho bảng `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"quanlycuahang\",\"table\":\"taikhoan\"},{\"db\":\"quanlycuahang\",\"table\":\"nhaphang\"},{\"db\":\"quanlycuahang\",\"table\":\"nhanvien\"},{\"db\":\"quanlycuahang\",\"table\":\"nhacungcap\"},{\"db\":\"quanlycuahang\",\"table\":\"khachhang\"},{\"db\":\"quanlycuahang\",\"table\":\"chatlieu\"},{\"db\":\"quanlycuahang\",\"table\":\"chitietphieunhap\"},{\"db\":\"cnpm\",\"table\":\"khachhang\"},{\"db\":\"quanlycuahang\",\"table\":\"hoadon\"},{\"db\":\"quanlycuahang\",\"table\":\"chitiethoadon\"}]');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin DEFAULT NULL,
  `data_sql` longtext COLLATE utf8_bin DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Đang đổ dữ liệu cho bảng `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2020-12-04 22:59:35', '{\"Console\\/Mode\":\"collapse\",\"lang\":\"vi\"}');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Chỉ mục cho bảng `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Chỉ mục cho bảng `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Chỉ mục cho bảng `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Chỉ mục cho bảng `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Chỉ mục cho bảng `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Chỉ mục cho bảng `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Chỉ mục cho bảng `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Chỉ mục cho bảng `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Chỉ mục cho bảng `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Chỉ mục cho bảng `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Chỉ mục cho bảng `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Chỉ mục cho bảng `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Chỉ mục cho bảng `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Cơ sở dữ liệu: `quanlycuahang`
--
CREATE DATABASE IF NOT EXISTS `quanlycuahang` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `quanlycuahang`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chatlieu`
--

CREATE TABLE `chatlieu` (
  `macl` varchar(10) NOT NULL,
  `maloai` varchar(10) NOT NULL,
  `mahang` varchar(10) NOT NULL,
  `tenhang` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chatlieu`
--

INSERT INTO `chatlieu` (`macl`, `maloai`, `mahang`, `tenhang`) VALUES
('CL1', 'áo', 'ASM', 'áo sơ mi'),
('CL2', 'AO', 'ATT', 'ÁO THỂ THAO'),
('CL3', 'AO', 'AT', 'ÁO TÂY'),
('CL4', 'AO', 'AA', 'ÁO ẤM'),
('CL5', 'AO', 'AK', 'ÁO KHOÁC'),
('CL6', 'QUAN', 'QNJ', 'QUẦN JEAN'),
('CL7', 'QUAN', 'QNS', 'QUẦN SHORT'),
('CL8', 'QUAN', 'QNT', 'QUẦN TÂY'),
('CL9', 'QUAN', 'QNTT', 'QUẦN THỜI TRANG'),
('CL10', 'QUAN', 'QNJG', 'QUẦN JOGGER'),
('CL11', 'QUAN', 'QNKK', 'QUẦN KAKI');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `mahd` varchar(10) NOT NULL,
  `mahang` varchar(10) NOT NULL,
  `maloai` varchar(10) NOT NULL,
  `macl` varchar(10) NOT NULL,
  `soluong` varchar(10) NOT NULL,
  `dongia` varchar(100) NOT NULL,
  `tongtien` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `mapn` varchar(10) NOT NULL,
  `mahang` varchar(10) NOT NULL,
  `maloai` varchar(10) NOT NULL,
  `macl` varchar(10) NOT NULL,
  `soluong` varchar(10) NOT NULL,
  `dongia` varchar(100) NOT NULL,
  `tongtien` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `makh` varchar(10) NOT NULL,
  `manv` varchar(10) NOT NULL,
  `mahd` varchar(10) NOT NULL,
  `tongtien` varchar(100) NOT NULL,
  `ngayban` varchar(10) NOT NULL,
  `ghichu` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`makh`, `manv`, `mahd`, `tongtien`, `ngayban`, `ghichu`) VALUES
('KH01', 'NV1', 'HĐ1', '', '22-09-2020', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` varchar(10) NOT NULL,
  `ho` varchar(10) NOT NULL,
  `ten` varchar(10) NOT NULL,
  `sodt` varchar(12) NOT NULL,
  `ngaysinh` varchar(10) NOT NULL,
  `gioitinh` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makh`, `ho`, `ten`, `sodt`, `ngaysinh`, `gioitinh`) VALUES
('KH01', 'NGUYỄN', 'VĂN TÁO', '0988878979', '23-05-1998', 'Nam'),
('KH02', 'NGUYỄN', 'THỊ THẮM ', '0972374567', '22-01-1997', 'NỮ'),
('KH03', 'TRẦN', 'ANH QUÂN', '0987153484', '09-09-2001', 'Nam'),
('KH04', 'CÔNG', 'DƯƠNG THÀN', '0909874672', '06-06-2003', 'Nam'),
('KH05', 'PHAN', 'CHÍ TÀI', '02809834578', '23-05-1996', 'Nam'),
('KH06', 'PHÙNG', 'NGUYÊN HƯN', '02837896753', '13-07-1998', 'Nam'),
('KH07', 'BÙI', 'THỊ BÍCH T', '0988894324', '23-12-1998', 'NỮ'),
('KH08', 'THÁI', 'MINH BẢO', '09698987474', '02-05-1991', 'Nam'),
('KH09', 'LÊ', 'VĂN HOÀN', '0288888888', '17-05-1995', 'Nam'),
('KH010', 'NGUYỄN', 'THỊ THẢO', '09845474948', '16-07-1998', 'NỮ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `mancc` varchar(10) NOT NULL,
  `tenncc` varchar(20) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `sodt` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`mancc`, `tenncc`, `diachi`, `sodt`) VALUES
('sdfdsa', 'sdfad', 'fdsafsd', 'dsfaf'),
('NCCAO0', 'QLO', '800-CMT8-PHƯỜNG 12 QUẬN TÂN BÌNH', '09873737373'),
('NCCAOA', 'QLA', '727-NGUYỄN TRI PHƯƠNG PHƯỜNG 9 QUẬN 5', '09845454545'),
('NCCAOC', 'QLC', '800-CMT8-PHƯỜNG 12 QUẬN TÂN BÌNH', '098777777777'),
('NCCQUAN', 'QLQ', '800-CMT8-PHƯỜNG 12 QUẬN TÂN BÌNH', '0286789123'),
('NCCQUANQ', 'QLQQ', '800-CMT8-PHƯỜNG 12 QUẬN TÂN BÌNH', '02808090705');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` varchar(10) NOT NULL,
  `ho` varchar(10) NOT NULL,
  `ten` varchar(10) NOT NULL,
  `gioitinh` varchar(10) NOT NULL,
  `ngaysinh` varchar(10) NOT NULL,
  `chucvu` varchar(10) NOT NULL,
  `luong` varchar(15) NOT NULL,
  `diachi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `ho`, `ten`, `gioitinh`, `ngaysinh`, `chucvu`, `luong`, `diachi`) VALUES
('NV1', 'NGUYỄN', 'QUANG LINH', 'NAM', '25-05-1998', 'NHÂN VIÊN', '5.5000.000', '23 NGUYỄN VĂN TRỖI PHƯỜNG 12 QUẬN 3'),
('NV2', 'NGUYỄN', 'TẤN PHÁT', 'NAM', '05-09-1998', 'NHÂN VIÊN', '5.5000.000', '03 NGUYÊN CHÍ THANH PHƯỜNG 9 QUẬN 5'),
('NV3', 'BÙI', 'THỊ HUỆ', 'NỮ', '01-08-2000', 'NHÂN VIÊN', '5.5000.000', '02 HOÀNG HOA THÁM PHƯỜNG 13 QUẬN TÂN BÌNH'),
('NV4', 'TRẦN', 'QUỐC TOẢN', 'NAM', '07-03-1997', 'NHÂN VIÊN', '5.5000.000', '256 DƯƠNG BÁ TRẠC PHƯỜNG 8 QUẬN 8'),
('NV5', 'TRỊNH', 'CÔNG THÀNH', 'NAM', '27-02-2003', 'NHÂN VIÊN', '5.5000.000', '29 NGUYỄN VĂN TRỖI PHƯỜNG 12 QUẬN 3'),
('NV6', 'NGUYỄN', 'THẢO NGUYÊ', 'NỮ', '22-01-2001', 'NHÂN VIÊN', '5.5000.000', '100 NGUYỄN THỊ MINH KHAI PHƯỜNG 9 QUẬN 6'),
('NV7', 'TRẦN', 'ANH TUẤN', 'NAM', '16-12-1995', 'NHÂN VIÊN', '5.5000.000', '23 NGUYỄN VĂN TRỖI PHƯỜNG 12 QUẬN 3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhaphang`
--

CREATE TABLE `nhaphang` (
  `mancc` varchar(10) NOT NULL,
  `manv` varchar(10) NOT NULL,
  `mapn` varchar(10) NOT NULL,
  `tongtien` varchar(15) NOT NULL,
  `ngaynhap` varchar(25) NOT NULL,
  `ghichu` varchar(100) NOT NULL,
  `inhoadon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhaphang`
--

INSERT INTO `nhaphang` (`mancc`, `manv`, `mapn`, `tongtien`, `ngaynhap`, `ghichu`, `inhoadon`) VALUES
('sdfdsa', '', 'PN1', '', '2020-11-25 15:24:08', '', 'DaInhoadon'),
('sdfdsa', '', 'PN2', '', '2020-11-25 16:59:29', 'dfdgdfg', 'ChuaInhoadon');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `manv` varchar(10) NOT NULL,
  `taikhoan` varchar(15) NOT NULL,
  `matkhau` varchar(15) NOT NULL,
  `phanquyen` varchar(15) NOT NULL,
  `trangthai` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`manv`, `taikhoan`, `matkhau`, `phanquyen`, `trangthai`) VALUES
('admin', 'admin', 'admin', 'admin', 'admin'),
('a', 'a', 'a', '', 'Đăng ký mới'),
('123', '', '', '', 'Đăng ký mới'),
('123', '', '', '', 'Đăng ký mới'),
('', '', '', '', 'Đăng ký mới'),
('', '', '', '', 'Đăng ký mới'),
('qewrqw', '', '', '', 'Đăng ký mới');
--
-- Cơ sở dữ liệu: `sinhvien`
--
CREATE DATABASE IF NOT EXISTS `sinhvien` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `sinhvien`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `masv` varchar(10) NOT NULL,
  `hoten` varchar(10) NOT NULL,
  `tuoi` int(10) NOT NULL,
  `malop` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`masv`, `hoten`, `tuoi`, `malop`) VALUES
('1', 'vuong', 21, 'DCT'),
('2', 'tung', 20, 'DCT'),
('3', 'triet', 30, 'DCT'),
('4', 'hoang', 25, 'IT'),
('5', 'duc', 24, 'IT'),
('6', 'hao', 18, 'IT');
--
-- Cơ sở dữ liệu: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
