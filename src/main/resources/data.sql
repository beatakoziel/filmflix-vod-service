ALTER TABLE movie CHANGE COLUMN description description VARCHAR(1000);

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(1,
        'Deadpool',
        'Były żołnierz oddziałów specjalnych zostaje poddany niebezpiecznemu eksperymentowi. Niebawem uwalnia swoje alter ego i rozpoczyna polowanie na człowieka, który niemal zniszczył jego życie.',
        '.videos/',
        'https://fwcdn.pl/fpo/46/75/514675/7762491.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(2,
        'Jak ukraść księżyc',
        'Życie Gru owładniętego żądzą kradzieży Księżyca zmienią trzy urocze sierotki.',
        'https://vwaw177.cda.pl/Cj1qGHfH9SZ5EOdLjQ75IA/1588568487/hd398a1b9ad5dedd59cd72be3d87c9a844.mp4',
        'https://fwcdn.pl/fpo/47/74/494774/7466063.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(3,
        'Glupi i głupszy',
        'Dwóch przyjaciół przemierza drogi i miasta Ameryki, by oddać zgubioną przez atrakcyjną kobietę walizkę.',
        'https://vwaw616.cda.pl/VF4XtZgJC3FrJPLLzwLYOw/1588568802/sdc836a768b35eb0637000918936c01592.mp4',
        'https://fwcdn.pl/fpo/59/94/5994/7534938.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(4,
        'Prości, ale bogaci',
        'Wszyscy mieszkańcy małej włoskiej wioski Torresecca wiedzą, że rodzina Tucci jest biedna jak mysz kościelna. Jej członkowie za wszelką cenę starają się jednak zachować pogodę ducha. Pewnego dnia niespodziewanie wygrywają na loterii 100 mln euro i wszystko w ich życiu się zmienia. Przenoszą się do luksusowego hotelu w Mediolanie i żyją, jakby miało nie być jutra. Sytuacja zdaje się ich nawet chwilami przerastać. Kiedy więc syn zakochuje się w kelnerce, która nienawidzi bogaczy, pozostali członkowie rodziny zaczynają udawać, że są biedni.',
        'https://vwaw716.cda.pl/ve_IeLIqSGQjMOSHV01hug/1588568973/hd5919bac424d4ce157c7749216572b0b6.mp4',
        'https://fwcdn.pl/fpo/71/02/787102/7843793.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(5,
        'Narzeczony mimo woli',
        'Margaret grozi deportacja, więc musi szybko wziąć z kimś ślub. Postanawia zaszantażować swojego asystenta.',
        'https://vwaw555.cda.pl/Q3mi97J4zYw_e5LTE9o-8w/1588569230/sdd155f15d68be97316fa1f60a75175747.mp4',
        'https://fwcdn.pl/fpo/77/10/437710/7302663.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(6,
        'Wyszczekani',
        'Pracujący w policji rottweiler zostaje wysłany na wystawę psów, aby zbadać sprawę handu zwierzętami.',
        'https://vger060.cda.pl/-GoN7ZBNyXl-X0XqR4sZ3Q/1588569366/sd2e70d2ec1fdcfb2b3afacffd19c6bffb85552f44e103a6e45522c8af16517b92.mp4',
        'https://fwcdn.pl/fpo/86/40/788640/7839170.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(7,
        'Przestępcza opowieść',
        'Jackie Chan gra specjalnego agenta, którego zadaniem jest chronić bogatego bisnesmana. Kiedy bisnesman ten zostaje porwany, Chan łączy siły z doświadczonym detektywem, by odbić zakładnika. Ale podejrzewa też, że to detektyw może być mózgiem kriminalnej organizacji.',
        'https://vwaw146.cda.pl/2uKEIA7O_8nNkWG0LRXG6Q/1588569890/hd6e31c7b278b3e12e89642e547e56eb95.mp4',
        'https://fwcdn.pl/fpo/49/35/124935/7345332.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(8,
        'Legenda Barneya Thomsona',
        'Golibroda z Glasgow nieoczekiwanie staje się poszukiwanym seryjnym mordercą.',
        'https://vwaw174.cda.pl/Fg0yMkKWSL6wyDiPKklsiQ/1588570125/hd5bc18e74d429ffee40bd823206879070.mp4',
        'https://fwcdn.pl/fpo/96/66/709666/7768014.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(9,
        'Wojownicze żółwie ninja 3',
        'Żółwie Ninja ruszają na ratunek swojej przyjaciółce, April, która nieumyślnie przeniosła się w czasie do siedemnastowiecznej Japonii, ogarniętej wojną partyzantów z feudalną władzą.',
        'https://vwaw123.cda.pl/_L1cIR4wMmOXpI6sYLwfQw/1588570236/hd2fa28a0a56e4b4423040cae18c070d1f.mp4',
        'https://fwcdn.pl/fpo/14/75/31475/7580963.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(10,
        'Pani szuka pana',
        'Świeżo upieczona emerytka postanawia urodzić dziecko.',
        'https://vwaw019.cda.pl/36KHpK5kTO422HvtiMvfbQ/1588570574/hddbbdd6e2eaccf159a93033da99c3ce29.mp4',
        'https://fwcdn.pl/fpo/14/86/711486/7626815.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(11,
        'Dziki cel',
        'Najemnik próbuje przejść na emeryturę, ale piękna złodziejka krzyżuje mu plany.',
        'https://vwaw110.cda.pl/aQPdmPrdim5hg1OmDCBE2g/1588570844/sd2e4f48634f44d81343d5f442edfc09f5.mp4',
        'https://fwcdn.pl/fpo/33/35/483335/7564738.3.jpg',
        'Komedia');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(12,
        'Snajper: niewidzialny zabójca',
        'Dwaj snajperzy otrzymują zadanie ochrony gazociągu.',
        'https://vwaw109.cda.pl/dudCx6sKHx87IWALoBKKAw/1588584326/hd32294106241ecc176b3c55b12e5ec248.mp4',
        'https://fwcdn.pl/fpo/90/27/759027/7792753.3.jpg',
        'Akcja');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(13,
        'Bóg wojny',
        'Azja, połowa XVI wieku. Przedłużający się konflikt Chin z japońskimi piratami zmusza dwóch chińskim generałów do podjęcia walki na niespotykaną do tej pory skalę.',
        'https://vger004.cda.pl/ZhX_ETGrl0sViTia4AyozA/1588584510/hdbb3e64dcff922f8a2ea5ee9ee75ec73d.mp4',
        'https://fwcdn.pl/fpo/68/24/796824/7817838.3.jpg',
        'Akcja');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(14,
        'Hellboy: Złota armia',
        'Hellboy musi stawić czoła zbudzonej przez okrutnego księcia armii niepokonanych bestii. Pomogą mu w tym przyjaciele o paranormalnych zdolnościach. ',
        'https://vger071.cda.pl/2kvZYaLTrrg5DgG00-Wzsg/1588584681/sd2yei89l0dci0a8wtkn43qoy9m5ztja8f357f52034f7d6ed5c67f4c76e0bf998a.mp4',
        'https://fwcdn.pl/fpo/55/96/135596/7295586.3.jpg',
        'Akcja');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(15,
        'Szybcy i wściekli: Tokio Drift',
        'Pasjonat nielegalnych wyścigów samochodowych ucieka przed więzieniem do Tokio. Ale tutaj też organizowane są niebezpieczne rajdy.',
        'https://vger033.cda.pl/Qmu-y_ayS1LWK9xLzZYuUg/1588584841/sdd8fff4d2a4b26c0a3a110bb670fc71d0e3fb1f70413046a1e00a136db7532fb0.mp4',
        'https://fwcdn.pl/fpo/92/15/119215/7124871.3.jpg',
        'Akcja');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(16,
        'Matrix',
        'Haker komputerowy Neo dowiaduje się od tajemniczych rebeliantów, że świat, w którym żyje, jest tylko obrazem przesyłanym do jego mózgu przez roboty.',
        'https://vwaw675.cda.pl/YRIAdLw3R-_ydzSQuWbJ5w/1588585014/hdc7d3913e6aa7d722f9ebb6c6bd91d2e1.mp4',
        'https://fwcdn.pl/fpo/06/28/628/7685907.3.jpg',
        'Akcja');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(17,
        'Podziemny krąg',
        'Dwóch mężczyzn znudzonych rutyną zakłada klub, w którym co tydzień odbywają się walki na gołe pięści.',
        'https://vwaw028.cda.pl/eivnrE0NCx_Uqg064ZbdhQ/1588585151/hdb3d4b91157f0a391feddc633796a09e2dc5939e71809ccd1bd3a98ca46f5a4e9.mp4',
        'https://fwcdn.pl/fpo/08/37/837/7742670.3.jpg',
        'Thriller');

replace into movie (id, title, description, resource_uri, cover_uri, category)
values(18,
        'Incepcja',
        'Szeryf federalny Daniels stara się dowiedzieć, jakim sposobem z zamkniętej celi w pilnie strzeżonym szpitalu dla chorych psychicznie przestępców zniknęła pacjentka.',
        'https://vwaw332.cda.pl/VQV-DEAUn0HddBMcmZW3HA/1588585300/hd3fcabc5dfc35b8e2261122f8cb4f43e6a6ed9d18f5bc925a35f4c27d53c84017.mp4',
        'https://fwcdn.pl/fpo/42/56/464256/7565178.3.jpg',
        'Thriller');
replace into movie (id, title, description, resource_uri, cover_uri, category)
values(19,
        'Efekt motyla',
        'Evan, który potrafi podróżować w czasie, przekona się, że nawet najdrobniejsza zmiana w przeszłości ma kolosalny wpływ na teraźniejszość.',
        'https://vwaw126.cda.pl/jLn_J4aBRKANIMCnLGXVpA/1588585397/sdf32a90f67a9da9f34fdaf3d989073e5b.mp4',
        'https://fwcdn.pl/fpo/02/52/40252/7788918.3.jpg',
        'Thriller');
replace into movie (id, title, description, resource_uri, cover_uri, category)
values(20,
        'Dziewczyna z tatuażem',
        'Ekranizacja powieści Stiega Larssona. Dziennikarz oskarżony o zniesławienie otrzymuje zlecenie zbadania zaginięcia przed 40 laty 16-letniej Harriet Vanger.',
        'https://vwaw580.cda.pl/Z41nAnHSPnnAeir00x8aiQ/1588585485/sd08e53604ca9da8f4e95e17c45ac8dd9d.mp4',
        'https://fwcdn.pl/fpo/56/37/565637/7748976.3.jpg',
        'Thriller');
replace into movie (id, title, description, resource_uri, cover_uri, category)
values(21,
        'Więzień labiryntu',
        'Nastoletni Thomas zostaje uwięziony w tajemniczym labiryncie, z którego próbuje się wydostać.',
        'https://vwaw690.cda.pl/Z0eqrQQimBHSEWnmS68jrA/1588585616/hdfaa02e83fd1412134914498d31056e99d17d0562eb239df2baddbbaeb1c5b66e.mp4',
        'https://fwcdn.pl/fpo/97/57/609757/7601693.3.jpg',
        'Thriller');
