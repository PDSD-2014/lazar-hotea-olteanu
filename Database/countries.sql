CREATE TABLE IF NOT EXISTS `countries` (
	`idCountry` int(5) NOT NULL AUTO_INCREMENT,
	`countryName` varchar(45) NOT NULL DEFAULT '',
	`currencyCode` char(3) DEFAULT NULL,
	`population` varchar(20) DEFAULT NULL,
	`capital` varchar(30) DEFAULT NULL,
	`continentName` varchar(15) DEFAULT NULL,
	`areaInSqKm` varchar(20) DEFAULT NULL,
	PRIMARY KEY (`idCountry`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=0;

INSERT INTO `countries` (`countryName`, `currencyCode`, `population`, `capital`, `continentName`, `areaInSqKm`) VALUES
('Andorra', 'EUR', '84000', 'Andorra la Vella', 'Europe', '468.0'),
('United Arab Emirates', 'AED', '4975593', 'Abu Dhabi', 'Asia', '82880.0'),
('Afghanistan', 'AFN', '29121286', 'Kabul', 'Asia', '647500.0'),
('Antigua and Barbuda', 'XCD', '86754', 'St. John\'s', 'North America', '443.0'),
('Anguilla', 'XCD', '13254', 'The Valley', 'North America', '102.0'),
('Albania', 'ALL', '2986952', 'Tirana', 'Europe', '28748.0'),
('Armenia', 'AMD', '2968000', 'Yerevan', 'Asia', '29800.0'),
('Angola', 'AOA', '13068161', 'Luanda', 'Africa', '1246700.0'),
('Antarctica', '', '0', '', 'Antarctica', '1.4E7'),
('Argentina', 'ARS', '41343201', 'Buenos Aires', 'South America', '2766890.0'),
('American Samoa', 'USD', '57881', 'Pago Pago', 'Oceania', '199.0'),
('Austria', 'EUR', '8205000', 'Vienna', 'Europe', '83858.0'),
('Australia', 'AUD', '21515754', 'Canberra', 'Oceania', '7686850.0'),
('Aruba', 'AWG', '71566', 'Oranjestad', 'North America', '193.0'),
('Åland', 'EUR', '26711', 'Mariehamn', 'Europe', ''),
('Azerbaijan', 'AZN', '8303512', 'Baku', 'Asia', '86600.0'),
('Bosnia and Herzegovina', 'BAM', '4590000', 'Sarajevo', 'Europe', '51129.0'),
('Barbados', 'BBD', '285653', 'Bridgetown', 'North America', '431.0'),
('Bangladesh', 'BDT', '156118464', 'Dhaka', 'Asia', '144000.0'),
('Belgium', 'EUR', '10403000', 'Brussels', 'Europe', '30510.0'),
('Burkina Faso', 'XOF', '16241811', 'Ouagadougou', 'Africa', '274200.0'),
('Bulgaria', 'BGN', '7148785', 'Sofia', 'Europe', '110910.0'),
('Bahrain', 'BHD', '738004', 'Manama', 'Asia', '665.0'),
('Burundi', 'BIF', '9863117', 'Bujumbura', 'Africa', '27830.0'),
('Benin', 'XOF', '9056010', 'Porto-Novo', 'Africa', '112620.0'),
('Saint Barthélemy', 'EUR', '8450', 'Gustavia', 'North America', '21.0'),
('Bermuda', 'BMD', '65365', 'Hamilton', 'North America', '53.0'),
('Brunei', 'BND', '395027', 'Bandar Seri Begawan', 'Asia', '5770.0'),
('Bolivia', 'BOB', '9947418', 'Sucre', 'South America', '1098580.0'),
('Bonaire', 'USD', '18012', '', 'North America', ''),
('Brazil', 'BRL', '201103330', 'Brasília', 'South America', '8511965.0'),
('Bahamas', 'BSD', '301790', 'Nassau', 'North America', '13940.0'),
('Bhutan', 'BTN', '699847', 'Thimphu', 'Asia', '47000.0'),
('Bouvet Island', 'NOK', '0', '', 'Antarctica', ''),
('Botswana', 'BWP', '2029307', 'Gaborone', 'Africa', '600370.0'),
('Belarus', 'BYR', '9685000', 'Minsk', 'Europe', '207600.0'),
('Belize', 'BZD', '314522', 'Belmopan', 'North America', '22966.0'),
('Canada', 'CAD', '33679000', 'Ottawa', 'North America', '9984670.0'),
('Cocos [Keeling] Islands', 'AUD', '628', 'West Island', 'Asia', '14.0'),
('Democratic Republic of the Congo', 'CDF', '70916439', 'Kinshasa', 'Africa', '2345410.0'),
('Central African Republic', 'XAF', '4844927', 'Bangui', 'Africa', '622984.0'),
('Republic of the Congo', 'XAF', '3039126', 'Brazzaville', 'Africa', '342000.0'),
('Switzerland', 'CHF', '7581000', 'Berne', 'Europe', '41290.0'),
('Ivory Coast', 'XOF', '21058798', 'Yamoussoukro', 'Africa', '322460.0'),
('Cook Islands', 'NZD', '21388', 'Avarua', 'Oceania', '240.0'),
('Chile', 'CLP', '16746491', 'Santiago', 'South America', '756950.0'),
('Cameroon', 'XAF', '19294149', 'Yaoundé', 'Africa', '475440.0'),
('China', 'CNY', '1330044000', 'Beijing', 'Asia', '9596960.0'),
('Colombia', 'COP', '44205293', 'Bogotá', 'South America', '1138910.0'),
('Costa Rica', 'CRC', '4516220', 'San José', 'North America', '51100.0'),
('Cuba', 'CUP', '11423000', 'Havana', 'North America', '110860.0'),
('Cape Verde', 'CVE', '508659', 'Praia', 'Africa', '4033.0'),
('Curacao', 'ANG', '141766', 'Willemstad', 'North America', ''),
('Christmas Island', 'AUD', '1500', 'The Settlement', 'Asia', '135.0'),
('Cyprus', 'EUR', '1102677', 'Nicosia', 'Europe', '9250.0'),
('Czechia', 'CZK', '10476000', 'Prague', 'Europe', '78866.0'),
('Germany', 'EUR', '81802257', 'Berlin', 'Europe', '357021.0'),
('Djibouti', 'DJF', '740528', 'Djibouti', 'Africa', '23000.0'),
('Denmark', 'DKK', '5484000', 'Copenhagen', 'Europe', '43094.0'),
('Dominica', 'XCD', '72813', 'Roseau', 'North America', '754.0'),
('Dominican Republic', 'DOP', '9823821', 'Santo Domingo', 'North America', '48730.0'),
('Algeria', 'DZD', '34586184', 'Algiers', 'Africa', '2381740.0'),
('Ecuador', 'USD', '14790608', 'Quito', 'South America', '283560.0'),
('Estonia', 'EUR', '1291170', 'Tallinn', 'Europe', '45226.0'),
('Egypt', 'EGP', '80471869', 'Cairo', 'Africa', '1001450.0'),
('Western Sahara', 'MAD', '273008', 'El Aaiún', 'Africa', '266000.0'),
('Eritrea', 'ERN', '5792984', 'Asmara', 'Africa', '121320.0'),
('Spain', 'EUR', '46505963', 'Madrid', 'Europe', '504782.0'),
('Ethiopia', 'ETB', '88013491', 'Addis Ababa', 'Africa', '1127127.0'),
('Finland', 'EUR', '5244000', 'Helsinki', 'Europe', '337030.0'),
('Fiji', 'FJD', '875983', 'Suva', 'Oceania', '18270.0'),
('Falkland Islands', 'FKP', '2638', 'Stanley', 'South America', '12173.0'),
('Micronesia', 'USD', '107708', 'Palikir', 'Oceania', '702.0'),
('Faroe Islands', 'DKK', '48228', 'Tórshavn', 'Europe', '1399.0'),
('France', 'EUR', '64768389', 'Paris', 'Europe', '547030.0'),
('Gabon', 'XAF', '1545255', 'Libreville', 'Africa', '267667.0'),
('United Kingdom', 'GBP', '62348447', 'London', 'Europe', '244820.0'),
('Grenada', 'XCD', '107818', 'St. George\'s', 'North America', '344.0'),
('Georgia', 'GEL', '4630000', 'Tbilisi', 'Asia', '69700.0'),
('French Guiana', 'EUR', '195506', 'Cayenne', 'South America', '91000.0'),
('Guernsey', 'GBP', '65228', 'St Peter Port', 'Europe', '78.0'),
('Ghana', 'GHS', '24339838', 'Accra', 'Africa', '239460.0'),
('Gibraltar', 'GIP', '27884', 'Gibraltar', 'Europe', '6.5'),
('Greenland', 'DKK', '56375', 'Nuuk', 'North America', '2166086.0'),
('Gambia', 'GMD', '1593256', 'Banjul', 'Africa', '11300.0'),
('Guinea', 'GNF', '10324025', 'Conakry', 'Africa', '245857.0'),
('Guadeloupe', 'EUR', '443000', 'Basse-Terre', 'North America', '1780.0'),
('Equatorial Guinea', 'XAF', '1014999', 'Malabo', 'Africa', '28051.0'),
('Greece', 'EUR', '11000000', 'Athens', 'Europe', '131940.0'),
('South Georgia and the South Sandwich Islands', 'GBP', '30', 'Grytviken', 'Antarctica', '3903.0'),
('Guatemala', 'GTQ', '13550440', 'Guatemala City', 'North America', '108890.0'),
('Guam', 'USD', '159358', 'Hagåtña', 'Oceania', '549.0'),
('Guinea-Bissau', 'XOF', '1565126', 'Bissau', 'Africa', '36120.0'),
('Guyana', 'GYD', '748486', 'Georgetown', 'South America', '214970.0'),
('Hong Kong', 'HKD', '6898686', 'Hong Kong', 'Asia', '1092.0'),
('Heard Island and McDonald Islands', 'AUD', '0', '', 'Antarctica', '412.0'),
('Honduras', 'HNL', '7989415', 'Tegucigalpa', 'North America', '112090.0'),
('Croatia', 'HRK', '4491000', 'Zagreb', 'Europe', '56542.0'),
('Haiti', 'HTG', '9648924', 'Port-au-Prince', 'North America', '27750.0'),
('Hungary', 'HUF', '9982000', 'Budapest', 'Europe', '93030.0'),
('Indonesia', 'IDR', '242968342', 'Jakarta', 'Asia', '1919440.0'),
('Ireland', 'EUR', '4622917', 'Dublin', 'Europe', '70280.0'),
('Israel', 'ILS', '7353985', '', 'Asia', '20770.0'),
('Isle of Man', 'GBP', '75049', 'Douglas', 'Europe', '572.0'),
('India', 'INR', '1173108018', 'New Delhi', 'Asia', '3287590.0'),
('British Indian Ocean Territory', 'USD', '4000', '', 'Asia', '60.0'),
('Iraq', 'IQD', '29671605', 'Baghdad', 'Asia', '437072.0'),
('Iran', 'IRR', '76923300', 'Tehran', 'Asia', '1648000.0'),
('Iceland', 'ISK', '308910', 'Reykjavik', 'Europe', '103000.0'),
('Italy', 'EUR', '60340328', 'Rome', 'Europe', '301230.0'),
('Jersey', 'GBP', '90812', 'Saint Helier', 'Europe', '116.0'),
('Jamaica', 'JMD', '2847232', 'Kingston', 'North America', '10991.0'),
('Jordan', 'JOD', '6407085', 'Amman', 'Asia', '92300.0'),
('Japan', 'JPY', '127288000', 'Tokyo', 'Asia', '377835.0'),
('Kenya', 'KES', '40046566', 'Nairobi', 'Africa', '582650.0'),
('Kyrgyzstan', 'KGS', '5508626', 'Bishkek', 'Asia', '198500.0'),
('Cambodia', 'KHR', '14453680', 'Phnom Penh', 'Asia', '181040.0'),
('Kiribati', 'AUD', '92533', 'Tarawa', 'Oceania', '811.0'),
('Comoros', 'KMF', '773407', 'Moroni', 'Africa', '2170.0'),
('Saint Kitts and Nevis', 'XCD', '51134', 'Basseterre', 'North America', '261.0'),
('North Korea', 'KPW', '22912177', 'Pyongyang', 'Asia', '120540.0'),
('South Korea', 'KRW', '48422644', 'Seoul', 'Asia', '98480.0'),
('Kuwait', 'KWD', '2789132', 'Kuwait City', 'Asia', '17820.0'),
('Cayman Islands', 'KYD', '44270', 'George Town', 'North America', '262.0'),
('Kazakhstan', 'KZT', '15340000', 'Astana', 'Asia', '2717300.0'),
('Laos', 'LAK', '6368162', 'Vientiane', 'Asia', '236800.0'),
('Lebanon', 'LBP', '4125247', 'Beirut', 'Asia', '10400.0'),
('Saint Lucia', 'XCD', '160922', 'Castries', 'North America', '616.0'),
('Liechtenstein', 'CHF', '35000', 'Vaduz', 'Europe', '160.0'),
('Sri Lanka', 'LKR', '21513990', 'Colombo', 'Asia', '65610.0'),
('Liberia', 'LRD', '3685076', 'Monrovia', 'Africa', '111370.0'),
('Lesotho', 'LSL', '1919552', 'Maseru', 'Africa', '30355.0'),
('Lithuania', 'LTL', '3565000', 'Vilnius', 'Europe', '65200.0'),
('Luxembourg', 'EUR', '497538', 'Luxembourg', 'Europe', '2586.0'),
('Latvia', 'LVL', '2217969', 'Riga', 'Europe', '64589.0'),
('Libya', 'LYD', '6461454', 'Tripoli', 'Africa', '1759540.0'),
('Morocco', 'MAD', '31627428', 'Rabat', 'Africa', '446550.0'),
('Monaco', 'EUR', '32965', 'Monaco', 'Europe', '1.95'),
('Moldova', 'MDL', '4324000', 'Chişinău', 'Europe', '33843.0'),
('Montenegro', 'EUR', '666730', 'Podgorica', 'Europe', '14026.0'),
('Saint Martin', 'EUR', '35925', 'Marigot', 'North America', '53.0'),
('Madagascar', 'MGA', '21281844', 'Antananarivo', 'Africa', '587040.0'),
('Marshall Islands', 'USD', '65859', 'Majuro', 'Oceania', '181.3'),
('Macedonia', 'MKD', '2062294', 'Skopje', 'Europe', '25333.0'),
('Mali', 'XOF', '13796354', 'Bamako', 'Africa', '1240000.0'),
('Myanmar [Burma]', 'MMK', '53414374', 'Nay Pyi Taw', 'Asia', '678500.0'),
('Mongolia', 'MNT', '3086918', 'Ulan Bator', 'Asia', '1565000.0'),
('Macao', 'MOP', '449198', 'Macao', 'Asia', '254.0'),
('Northern Mariana Islands', 'USD', '53883', 'Saipan', 'Oceania', '477.0'),
('Martinique', 'EUR', '432900', 'Fort-de-France', 'North America', '1100.0'),
('Mauritania', 'MRO', '3205060', 'Nouakchott', 'Africa', '1030700.0'),
('Montserrat', 'XCD', '9341', 'Plymouth', 'North America', '102.0'),
('Malta', 'EUR', '403000', 'Valletta', 'Europe', '316.0'),
('Mauritius', 'MUR', '1294104', 'Port Louis', 'Africa', '2040.0'),
('Maldives', 'MVR', '395650', 'Malé', 'Asia', '300.0'),
('Malawi', 'MWK', '15447500', 'Lilongwe', 'Africa', '118480.0'),
('Mexico', 'MXN', '112468855', 'Mexico City', 'North America', '1972550.0'),
('Malaysia', 'MYR', '28274729', 'Kuala Lumpur', 'Asia', '329750.0'),
('Mozambique', 'MZN', '22061451', 'Maputo', 'Africa', '801590.0'),
('Namibia', 'NAD', '2128471', 'Windhoek', 'Africa', '825418.0'),
('New Caledonia', 'XPF', '216494', 'Noumea', 'Oceania', '19060.0'),
('Niger', 'XOF', '15878271', 'Niamey', 'Africa', '1267000.0'),
('Norfolk Island', 'AUD', '1828', 'Kingston', 'Oceania', '34.6'),
('Nigeria', 'NGN', '154000000', 'Abuja', 'Africa', '923768.0'),
('Nicaragua', 'NIO', '5995928', 'Managua', 'North America', '129494.0'),
('Netherlands', 'EUR', '16645000', 'Amsterdam', 'Europe', '41526.0'),
('Norway', 'NOK', '5009150', 'Oslo', 'Europe', '324220.0'),
('Nepal', 'NPR', '28951852', 'Kathmandu', 'Asia', '140800.0'),
('Nauru', 'AUD', '10065', '', 'Oceania', '21.0'),
('Niue', 'NZD', '2166', 'Alofi', 'Oceania', '260.0'),
('New Zealand', 'NZD', '4252277', 'Wellington', 'Oceania', '268680.0'),
('Oman', 'OMR', '2967717', 'Muscat', 'Asia', '212460.0'),
('Panama', 'PAB', '3410676', 'Panama City', 'North America', '78200.0'),
('Peru', 'PEN', '29907003', 'Lima', 'South America', '1285220.0'),
('French Polynesia', 'XPF', '270485', 'Papeete', 'Oceania', '4167.0'),
('Papua New Guinea', 'PGK', '6064515', 'Port Moresby', 'Oceania', '462840.0'),
('Philippines', 'PHP', '99900177', 'Manila', 'Asia', '300000.0'),
('Pakistan', 'PKR', '184404791', 'Islamabad', 'Asia', '803940.0'),
('Poland', 'PLN', '38500000', 'Warsaw', 'Europe', '312685.0'),
('Saint Pierre and Miquelon', 'EUR', '7012', 'Saint-Pierre', 'North America', '242.0'),
('Pitcairn Islands', 'NZD', '46', 'Adamstown', 'Oceania', '47.0'),
('Puerto Rico', 'USD', '3916632', 'San Juan', 'North America', '9104.0'),
('Palestine', 'ILS', '3800000', '', 'Asia', '5970.0'),
('Portugal', 'EUR', '10676000', 'Lisbon', 'Europe', '92391.0'),
('Palau', 'USD', '19907', 'Melekeok - Palau State Capital', 'Oceania', '458.0'),
('Paraguay', 'PYG', '6375830', 'Asunción', 'South America', '406750.0'),
('Qatar', 'QAR', '840926', 'Doha', 'Asia', '11437.0'),
('Réunion', 'EUR', '776948', 'Saint-Denis', 'Africa', '2517.0'),
('Romania', 'RON', '21959278', 'Bucharest', 'Europe', '237500.0'),
('Serbia', 'RSD', '7344847', 'Belgrade', 'Europe', '88361.0'),
('Russia', 'RUB', '140702000', 'Moscow', 'Europe', '1.71E7'),
('Rwanda', 'RWF', '11055976', 'Kigali', 'Africa', '26338.0'),
('Saudi Arabia', 'SAR', '25731776', 'Riyadh', 'Asia', '1960582.0'),
('Solomon Islands', 'SBD', '559198', 'Honiara', 'Oceania', '28450.0'),
('Seychelles', 'SCR', '88340', 'Victoria', 'Africa', '455.0'),
('Sudan', 'SDG', '35000000', 'Khartoum', 'Africa', '1861484.0'),
('Sweden', 'SEK', '9555893', 'Stockholm', 'Europe', '449964.0'),
('Singapore', 'SGD', '4701069', 'Singapore', 'Asia', '692.7'),
('Saint Helena', 'SHP', '7460', 'Jamestown', 'Africa', '410.0'),
('Slovenia', 'EUR', '2007000', 'Ljubljana', 'Europe', '20273.0'),
('Svalbard and Jan Mayen', 'NOK', '2550', 'Longyearbyen', 'Europe', '62049.0'),
('Slovakia', 'EUR', '5455000', 'Bratislava', 'Europe', '48845.0'),
('Sierra Leone', 'SLL', '5245695', 'Freetown', 'Africa', '71740.0'),
('San Marino', 'EUR', '31477', 'San Marino', 'Europe', '61.2'),
('Senegal', 'XOF', '12323252', 'Dakar', 'Africa', '196190.0'),
('Somalia', 'SOS', '10112453', 'Mogadishu', 'Africa', '637657.0'),
('Suriname', 'SRD', '492829', 'Paramaribo', 'South America', '163270.0'),
('South Sudan', 'SSP', '8260490', 'Juba', 'Africa', '644329.0'),
('São Tomé and Príncipe', 'STD', '175808', 'São Tomé', 'Africa', '1001.0'),
('El Salvador', 'USD', '6052064', 'San Salvador', 'North America', '21040.0'),
('Sint Maarten', 'ANG', '37429', 'Philipsburg', 'North America', ''),
('Syria', 'SYP', '22198110', 'Damascus', 'Asia', '185180.0'),
('Swaziland', 'SZL', '1354051', 'Mbabane', 'Africa', '17363.0'),
('Turks and Caicos Islands', 'USD', '20556', 'Cockburn Town', 'North America', '430.0'),
('Chad', 'XAF', '10543464', 'N\'Djamena', 'Africa', '1284000.0'),
('French Southern Territories', 'EUR', '140', 'Port-aux-Français', 'Antarctica', '7829.0'),
('Togo', 'XOF', '6587239', 'Lomé', 'Africa', '56785.0'),
('Thailand', 'THB', '67089500', 'Bangkok', 'Asia', '514000.0'),
('Tajikistan', 'TJS', '7487489', 'Dushanbe', 'Asia', '143100.0'),
('Tokelau', 'NZD', '1466', '', 'Oceania', '10.0'),
('East Timor', 'USD', '1154625', 'Dili', 'Oceania', '15007.0'),
('Turkmenistan', 'TMT', '4940916', 'Ashgabat', 'Asia', '488100.0'),
('Tunisia', 'TND', '10589025', 'Tunis', 'Africa', '163610.0'),
('Tonga', 'TOP', '122580', 'Nuku\'alofa', 'Oceania', '748.0'),
('Turkey', 'TRY', '77804122', 'Ankara', 'Asia', '780580.0'),
('Trinidad and Tobago', 'TTD', '1228691', 'Port of Spain', 'North America', '5128.0'),
('Tuvalu', 'AUD', '10472', 'Funafuti', 'Oceania', '26.0'),
('Taiwan', 'TWD', '22894384', 'Taipei', 'Asia', '35980.0'),
('Tanzania', 'TZS', '41892895', 'Dodoma', 'Africa', '945087.0'),
('Ukraine', 'UAH', '45415596', 'Kyiv', 'Europe', '603700.0'),
('Uganda', 'UGX', '33398682', 'Kampala', 'Africa', '236040.0'),
('U.S. Minor Outlying Islands', 'USD', '0', '', 'Oceania', '0.0'),
('United States', 'USD', '310232863', 'Washington', 'North America', '9629091.0'),
('Uruguay', 'UYU', '3477000', 'Montevideo', 'South America', '176220.0'),
('Uzbekistan', 'UZS', '27865738', 'Tashkent', 'Asia', '447400.0'),
('Vatican City', 'EUR', '921', 'Vatican', 'Europe', '0.44'),
('Saint Vincent and the Grenadines', 'XCD', '104217', 'Kingstown', 'North America', '389.0'),
('Venezuela', 'VEF', '27223228', 'Caracas', 'South America', '912050.0'),
('British Virgin Islands', 'USD', '21730', 'Road Town', 'North America', '153.0'),
('U.S. Virgin Islands', 'USD', '108708', 'Charlotte Amalie', 'North America', '352.0'),
('Vietnam', 'VND', '89571130', 'Hanoi', 'Asia', '329560.0'),
('Vanuatu', 'VUV', '221552', 'Port Vila', 'Oceania', '12200.0'),
('Wallis and Futuna', 'XPF', '16025', 'Mata-Utu', 'Oceania', '274.0'),
('Samoa', 'WST', '192001', 'Apia', 'Oceania', '2944.0'),
('Kosovo', 'EUR', '1800000', 'Pristina', 'Europe', ''),
('Yemen', 'YER', '23495361', 'Sanaa', 'Asia', '527970.0'),
('Mayotte', 'EUR', '159042', 'Mamoutzou', 'Africa', '374.0'),
('South Africa', 'ZAR', '49000000', 'Pretoria', 'Africa', '1219912.0'),
('Zambia', 'ZMK', '13460305', 'Lusaka', 'Africa', '752614.0'),
('Zimbabwe', 'ZWL', '11651858', 'Harare', 'Africa', '390580.0')
