package com.example.myapplication.model

import com.example.myapplication.R

data class MiningItem(
    val id: String,
    val title: String,
    val category: String,
    val price: String,
    val description: String,
    val manufacturer: String,
    val year: String,
    val seller: String,
    val imageRes: Int? = null
)

data class MarketplaceCategory(
    val id: String,
    val name: String,
    val iconName: String
)

data class RouteStep(
    val stepNumber: Int,
    val highway: String,
    val instruction: String,
    val distance: String
)

data class MineLocation(
    val id: String,
    val name: String,
    val region: String,
    val district: String,
    val distance: String,
    val estTime: String,
    val type: String,
    val terrain: String,
    val startingPoint: String = "Kathmandu Hub",
    val status: String = "Active Nepal Mining Site",
    val routeSteps: List<RouteStep>,
    val latRatio: Float,
    val lngRatio: Float
)

val sampleMiningItems = listOf(
    MiningItem(
        id = "1",
        title = "Himalayan Gold Washing & Sluice Plant",
        category = "Drilling",
        price = "NPR 6,500,000",
        description = "High-efficiency mobile gold sluice and washing plant customized for Nepal riverbed placer gold extraction and gravel separation.",
        manufacturer = "Himalaya Mining Heavy Equipment",
        year = "2023",
        seller = "Ramesh Sharma (Pokhara)",
        imageRes = R.drawable.img_washing_plant
    ),
    MiningItem(
        id = "2",
        title = "Nepal Heavy Mountain Rock Breaker",
        category = "Electric",
        price = "NPR 400,000",
        description = "1700 Watt high-impact electric rock breaker designed for steep mountain terrain and hard rock prospecting in Nepal.",
        manufacturer = "PowerTool Nepal Corp",
        year = "2022",
        seller = "Bikas Thapa (Kathmandu)",
        imageRes = R.drawable.img_jackhammer
    ),
    MiningItem(
        id = "3",
        title = "Gold Finder CTX3030 Pro Detector",
        category = "Electronic",
        price = "NPR 650,000",
        description = "Waterproof multi-frequency gold detection machine with built-in GPS mapping and target discrimination for Himalayan riverbeds.",
        manufacturer = "Loop Techno Systems",
        year = "2020",
        seller = "Ali Ibrahim (Biratnagar)",
        imageRes = R.drawable.img_ctx3030
    )
)

val sampleCategories = listOf(
    MarketplaceCategory("1", "Electronic", "Memory"),
    MarketplaceCategory("2", "Electric", "FlashOn"),
    MarketplaceCategory("3", "Wanted", "Search"),
    MarketplaceCategory("4", "Drilling", "Build"),
    MarketplaceCategory("5", "Marketplace", "Store"),
    MarketplaceCategory("6", "Car rentals", "DirectionsCar")
)

val sampleMineLocations = listOf(
    MineLocation(
        id = "1",
        name = "Kaligandaki River Gold Deposit",
        region = "Gandaki Province",
        district = "Mustang / Parbat District",
        distance = "285 km",
        estTime = "6h 45m",
        type = "Alluvial Placer Gold Deposit",
        terrain = "Highway & Mountain Riverbed Road",
        routeSteps = listOf(
            RouteStep(1, "Prithvi Highway (H02)", "Depart Kathmandu Westbound through Naubise to Pokhara Junction", "200 km"),
            RouteStep(2, "Pokhara-Baglung Highway (H10)", "Head North-West towards Beni, Myagdi District", "65 km"),
            RouteStep(3, "Kaligandaki Corridor Road", "Follow river corridor track to Kaligandaki Gold Extraction Site", "20 km")
        ),
        latRatio = 0.38f,
        lngRatio = 0.32f
    ),
    MineLocation(
        id = "2",
        name = "Bheri River Prospecting Site",
        region = "Karnali Province",
        district = "Surkhet / Jajarkot District",
        distance = "510 km",
        estTime = "11h 30m",
        type = "Gold & Gemstone Prospecting Basin",
        terrain = "Chhinchu-Jajarkot Highway",
        routeSteps = listOf(
            RouteStep(1, "East-West Highway (H01)", "Proceed Westbound along Terai Highway to Kohalpur Junction", "420 km"),
            RouteStep(2, "Ratna Highway (H12)", "Head North through Birendranagar, Surkhet Valley", "50 km"),
            RouteStep(3, "Chhinchu-Jajarkot Highway", "Follow Bheri river valley road to Jajarkot Mining Camp", "40 km")
        ),
        latRatio = 0.28f,
        lngRatio = 0.72f
    ),
    MineLocation(
        id = "3",
        name = "Phulchoki Precious Metals Deposit",
        region = "Bagmati Province",
        district = "Lalitpur District",
        distance = "28 km",
        estTime = "1h 15m",
        type = "Iron, Zinc & Gold Quartz Vein",
        terrain = "Hilly Alpine Winding Road",
        routeSteps = listOf(
            RouteStep(1, "Kathmandu Ring Road", "Depart Ring Road at Satdobato Junction, Lalitpur", "8 km"),
            RouteStep(2, "Godawari Main Road", "Proceed South towards Godawari Botanical Base Camp", "12 km"),
            RouteStep(3, "Phulchoki Hill Access Trail", "Ascend winding mountain road to Mine Shaft Gate 1", "8 km")
        ),
        latRatio = 0.62f,
        lngRatio = 0.52f
    ),
    MineLocation(
        id = "4",
        name = "Ganesh Himal Mineral Zone",
        region = "Bagmati Province",
        district = "Rasuwa District",
        distance = "145 km",
        estTime = "5h 20m",
        type = "Zinc, Lead, Silver & Gold Mine",
        terrain = "Pasang Lhamu Highway (H07)",
        routeSteps = listOf(
            RouteStep(1, "Pasang Lhamu Highway (H07)", "Head North through Trishuli Bazaar to Dhunche", "75 km"),
            RouteStep(2, "Dhunche-Syabrubesi Road", "Navigate mountain curves towards Syabrubesi Base", "45 km"),
            RouteStep(3, "Mine Track Ascent", "Take heavy machinery track to Ganesh Himal Extraction Shaft", "25 km")
        ),
        latRatio = 0.72f,
        lngRatio = 0.28f
    ),
    MineLocation(
        id = "5",
        name = "Sunkoshi River Placer Deposit",
        region = "Koshi Province",
        district = "Sindhuli District",
        distance = "135 km",
        estTime = "3h 40m",
        type = "Riverbed Gold Panning Deposit",
        terrain = "BP Koirala Highway",
        routeSteps = listOf(
            RouteStep(1, "Arniko Highway (H03)", "Depart Kathmandu Eastbound to Dhulikhel Junction", "30 km"),
            RouteStep(2, "BP Koirala Highway", "Descend scenic highway towards Khurkot Bridge", "85 km"),
            RouteStep(3, "Sunkoshi River Bank Trail", "Follow riverbank track to Placer Gold Panning Site", "20 km")
        ),
        latRatio = 0.52f,
        lngRatio = 0.82f
    )
)
