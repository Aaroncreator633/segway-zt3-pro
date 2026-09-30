package com.celox.segway

import android.content.Intent
import android.graphics.Color as AndroidColor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AaronDashboardActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = AndroidColor.TRANSPARENT
        window.navigationBarColor = AndroidColor.rgb(5, 14, 31)

        setContent {
            AaronDashboard(
                onOpenFullApp = {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            )
        }
    }
}

private val Navy950 = Color(0xFF050E1F)
private val Navy900 = Color(0xFF08162D)
private val Navy800 = Color(0xFF0C2342)
private val Navy700 = Color(0xFF12355B)
private val ElectricBlue = Color(0xFF4BA3FF)
private val GlassWhite = Color.White.copy(alpha = 0.075f)
private val GlassBorder = Color.White.copy(alpha = 0.14f)

@Composable
private fun AaronDashboard(
    onOpenFullApp: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Navy950
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFF102E50),
                            Navy950,
                            Color(0xFF030914)
                        )
                    )
                )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                Spacer(Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "AARON",
                            color = ElectricBlue,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp
                        )
                        Text(
                            text = "ZT3 PRO E",
                            color = Color.White,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    Card(
                        shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White.copy(alpha = 0.08f)
                        ),
                        border = BorderStroke(1.dp, GlassBorder)
                    ) {
                        Text(
                            text = "EU • 25 KM/H",
                            modifier = Modifier.padding(
                                horizontal = 13.dp,
                                vertical = 8.dp
                            ),
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // --------------------------------------------------
                // HERO IMAGE
                // --------------------------------------------------

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(30.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = GlassWhite
                    ),
                    border = BorderStroke(1.dp, GlassBorder)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(245.dp)
                            .clip(RoundedCornerShape(30.dp))
                    ) {
                        Image(
                            painter = painterResource(
                                id = com.celox.segway.R.drawable.zt3_hero
                            ),
                            contentDescription = "Segway ZT3 Pro E",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        listOf(
                                            Color.Transparent,
                                            Color.Black.copy(alpha = 0.72f)
                                        )
                                    )
                                )
                        )

                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(18.dp)
                        ) {
                            Text(
                                text = "TA ZT3. TON STYLE.",
                                color = Color.White,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                            Text(
                                text = "051801E • édition Aaron",
                                color = Color.White.copy(alpha = 0.78f),
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                // --------------------------------------------------
                // CONNEXION
                // --------------------------------------------------

                GlassCard {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .clip(RoundedCornerShape(50.dp))
                                .background(ElectricBlue)
                        ) {}

                        Spacer(Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Connexion Bluetooth",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(
                                text = "BLE disponible • connexion via l’application complète",
                                color = Color.White.copy(alpha = 0.62f),
                                fontSize = 11.sp
                            )
                        }
                    }
                }

                // --------------------------------------------------
                // SPEED
                // --------------------------------------------------

                GlassCard {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "ACTION RAPIDE",
                                    color = ElectricBlue,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 1.5.sp
                                )
                                Text(
                                    text = "Limite de vitesse",
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Text(
                                text = "15 ↔ 25",
                                color = Color.White,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            SpeedButton(
                                text = "15 km/h",
                                modifier = Modifier.weight(1f),
                                onClick = onOpenFullApp
                            )

                            SpeedButton(
                                text = "25 km/h",
                                modifier = Modifier.weight(1f),
                                onClick = onOpenFullApp
                            )
                        }

                        Text(
                            text = "Les boutons ouvrent pour l’instant les commandes BLE existantes. Le basculement direct sera branché après validation du protocole ZT3 Pro E.",
                            color = Color.White.copy(alpha = 0.52f),
                            fontSize = 10.sp,
                            lineHeight = 14.sp
                        )
                    }
                }

                // --------------------------------------------------
                // PHOTO SECONDAIRE + INFOS
                // --------------------------------------------------

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .height(175.dp),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = GlassWhite
                        ),
                        border = BorderStroke(1.dp, GlassBorder)
                    ) {
                        Image(
                            painter = painterResource(
                                id = com.celox.segway.R.drawable.zt3_side
                            ),
                            contentDescription = "ZT3 Pro E",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(24.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }

                    GlassCard(
                        modifier = Modifier
                            .weight(1f)
                            .height(175.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            SpecLine("Vitesse max", "25 km/h")
                            Divider(color = Color.White.copy(alpha = 0.10f))
                            SpecLine("Autonomie max", "≈ 70 km")
                            Divider(color = Color.White.copy(alpha = 0.10f))
                            SpecLine("Batterie", "597 Wh")
                            Divider(color = Color.White.copy(alpha = 0.10f))
                            SpecLine("Pneus", "11 pouces")
                        }
                    }
                }

                // --------------------------------------------------
                // BOUTON FULL APP
                // --------------------------------------------------

                Button(
                    onClick = onOpenFullApp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ElectricBlue,
                        contentColor = Navy950
                    )
                ) {
                    Text(
                        text = "OUVRIR LES COMMANDES BLE",
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.8.sp
                    )
                }

                Text(
                    text = "AARON • ZT3 CONTROL",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    color = Color.White.copy(alpha = 0.35f),
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun GlassCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = GlassWhite
        ),
        border = BorderStroke(1.dp, GlassBorder),
        content = content
    )
}

@Composable
private fun SpeedButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(17.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Navy700,
            contentColor = Color.White
        )
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun SpecLine(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = Color.White.copy(alpha = 0.60f),
            fontSize = 10.sp
        )
        Text(
            text = value,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
