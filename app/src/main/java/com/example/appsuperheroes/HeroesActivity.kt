package com.example.appsuperheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appsuperheroes.model.Hero
import com.example.appsuperheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroesList(heroes: List<Hero>, modifier: Modifier = Modifier, contentPadding: PaddingValues = PaddingValues(4.dp)) {

    LazyColumn(contentPadding = contentPadding) {
        items(heroes) {  hero ->
            HeroListItem(
                hero = hero,
                modifier = Modifier
                    .padding(horizontal = (dimensionResource(id = R.dimen.paddingMedium)),
                        vertical = (dimensionResource(id = R.dimen.paddingSmall)))
            )
        }
    }

}

@Composable
fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.cardElevation)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.paddingMedium))
                .sizeIn(minHeight = dimensionResource(id = R.dimen.sizeMedium))
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(Modifier.width(dimensionResource(id = R.dimen.paddingMedium)))

                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.sizeMedium))
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.paddingSmall))),
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
        }
    }
}

@Preview
@Composable
fun HeroesPreview() {
    SuperheroesTheme(darkTheme = false) {
        HeroesApp()
    }
}
@Preview
@Composable
fun HeroesDarkThemePreview(){
    SuperheroesTheme(darkTheme = true){
        HeroesApp()
    }
}