    package com.example.littlelemon

    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material.BottomNavigation
    import androidx.compose.material.BottomNavigationItem
    import androidx.compose.material3.Icon
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.saveable.rememberSaveable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavController
    import androidx.navigation.NavType
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import androidx.navigation.navArgument

    @Composable
    fun MyNavigation() {
        val navController = rememberNavController()
        Scaffold(bottomBar = { MyBottomNavigation(navController = navController) }) {
            Box(Modifier.padding(it)) {
                NavHost(navController = navController, startDestination = Home.route) {
                    composable(Menu.route) {
                        MyMenuDest()
                    }
                    composable(Home.route) {
                        MyMenuDestinations()
                    }
                    composable(Location.route) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            androidx.compose.material.Text(
                                text = "Location Screen",
                                fontSize = 36.sp
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun MyBottomNavigation(navController: NavController) {
        val tabbedDestinationsList = listOf<TabbedDestinations>(
            TabbedHome,
            Menu,
            Location
        )
        val selectedIndex = rememberSaveable{
            mutableStateOf(0)
        }
        BottomNavigation() {
            tabbedDestinationsList.forEachIndexed { index, tabbedDestinations ->
                BottomNavigationItem(label = { Text(text = tabbedDestinations.title) }, icon = { Icon(painter = painterResource(id = tabbedDestinations.icon), contentDescription =tabbedDestinations.title) },
                    selected = index == selectedIndex.value,
                    onClick ={
                        selectedIndex.value = index
                        navController.navigate(tabbedDestinationsList[index].route) {
                            popUpTo(Home.route)
                            launchSingleTop = true
                        }
                    })
            }
        }
    }

    @Composable
    fun MyMenuDestinations(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Home.route) {
            composable(Home.route) {
                HomeScreen(navController)
            }
            composable(
                DishDetails.route + "/{${DishDetails.argDishId}}",
                arguments = listOf(navArgument(DishDetails.argDishId) { type = NavType.IntType })
            ) {
                val id = requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
                DishDetails(id)
            }
        }
    }

    @Composable
    fun MyMenuDest(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Menu.route) {
            composable(Menu.route) {
                LowerPanel(navController, DishRepository.dishes)
            }
            composable(
                DishDetails.route + "/{${DishDetails.argDishId}}",
                arguments = listOf(navArgument(DishDetails.argDishId) { type = NavType.IntType })
            ) {
                val id = requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
                DishDetails(id)
            }
        }
    }