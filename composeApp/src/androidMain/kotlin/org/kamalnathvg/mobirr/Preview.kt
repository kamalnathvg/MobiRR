package org.kamalnathvg.mobirr

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.serialization.json.Json
import org.kamalnathvg.mobirr.radarr.data.MovieDto
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.Movie
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListScreen
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.MovieListScreenState
import org.kamalnathvg.mobirr.radarr.presentation.movie_list.toMovie


@Preview(showSystemUi = true)
@Composable
internal fun MovieListPreviews() {
    var movies by remember { mutableStateOf<List<Movie>>(emptyList()) }
    val json = Json { ignoreUnknownKeys = true }
    val moviesDto = json.decodeFromString<List<MovieDto>>(moviesJson)
    movies = moviesDto.map { it.toMovie() }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        MovieListScreen(
            state = MovieListScreenState(
                filteredMovies = movies,
                errorMessage = null
            ),
            onAction = {}
        )
    }

}


val moviesJson = """
    [
      {
        "title": "Vaazha: Biopic of a Billion Boys",
        "originalTitle": "വാഴ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "vaazha biopic billion boys",
        "sizeOnDisk": 1542839141,
        "status": "released",
        "overview": "Four friends deemed 'losers' face immense pressure from parents and society upon entering adulthood. Their emotional tale sees them embark on a journey of self-discovery and acceptance, where love ultimately triumphs over judgment.",
        "inCinemas": "2024-08-15T00:00:00Z",
        "releaseDate": "2024-11-13T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/1/poster.jpg?lastWrite=638703273710643552",
            "remoteUrl": "https://image.tmdb.org/t/p/original/gGXANU8i7r2YgRxC8PiQUGgGB4p.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/1/fanart.jpg?lastWrite=638833035360187867",
            "remoteUrl": "https://image.tmdb.org/t/p/original/65vGOUKdIycwaXdXbzdN1ns8jaL.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "WBTS Productions",
        "path": "/movies/Vaazha (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 3,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Vaazha (2024)",
        "runtime": 125,
        "cleanTitle": "vaazhabiopicbillionboys",
        "imdbId": "tt29470244",
        "tmdbId": 1189518,
        "titleSlug": "1189518",
        "rootFolderPath": "/movies/",
        "genres": [
          "Comedy",
          "Drama"
        ],
        "tags": [],
        "added": "2024-09-24T21:20:47Z",
        "ratings": {
          "imdb": {
            "votes": 4187,
            "value": 7.3,
            "type": "user"
          },
          "tmdb": {
            "votes": 12,
            "value": 6.292,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 1,
          "relativePath": "Vaazha (2024).mkv",
          "path": "/movies/Vaazha (2024)/Vaazha (2024).mkv",
          "size": 1542839141,
          "dateAdded": "2024-09-24T23:00:57Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:02:55",
            "scanType": "Progressive",
            "subtitles": "eng/eng/eng/eng"
          },
          "qualityCutoffNotMet": false,
          "id": 3
        },
        "collection": {
          "title": "Vaazha Collection",
          "tmdbId": 1336775
        },
        "popularity": 0.7327,
        "lastSearchTime": "2024-09-24T23:04:02Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1542839141,
          "releaseGroups": []
        },
        "id": 1
      },
      {
        "title": "American Psycho",
        "originalTitle": "American Psycho",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 3,
            "title": "美国杀人狂",
            "id": 1
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 3,
            "title": "Амерички психо",
            "id": 2
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 3,
            "title": "アメリカン・サイコ",
            "id": 3
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 3,
            "title": "Kẻ Sát Nhân Cuồng Tín",
            "id": 5
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 3,
            "title": "Amerikan Psixi",
            "id": 6
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 3,
            "title": "Psicópata americano",
            "id": 7
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 3,
            "title": "아메리칸 싸이코",
            "id": 261
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 3,
            "title": "Ամերիկյան Խելագառ",
            "id": 301
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "american psycho",
        "sizeOnDisk": 1500134210,
        "status": "released",
        "overview": "A wealthy New York investment banking executive hides his alternate psychopathic ego from his co-workers and friends as he escalates deeper into his illogical, gratuitous fantasies.",
        "inCinemas": "2000-04-13T00:00:00Z",
        "physicalRelease": "2000-10-27T00:00:00Z",
        "digitalRelease": "2015-03-04T00:00:00Z",
        "releaseDate": "2000-10-27T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/2/poster.jpg?lastWrite=638822665166898866",
            "remoteUrl": "https://image.tmdb.org/t/p/original/9uGHEgsiUXjCNq8wdq4r49YL8A1.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/2/fanart.jpg?lastWrite=638804428311212766",
            "remoteUrl": "https://image.tmdb.org/t/p/original/rRwD4MoBlkBXWQ6PDnbKRSU5dDu.jpg"
          }
        ],
        "website": "",
        "year": 2000,
        "youTubeTrailerId": "81mibtQWWBg",
        "studio": "Lionsgate",
        "path": "/movies/American Psycho (2000)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 2,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/American Psycho (2000)",
        "runtime": 102,
        "cleanTitle": "americanpsycho",
        "imdbId": "tt0144084",
        "tmdbId": 1359,
        "titleSlug": "1359",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Thriller",
          "Drama",
          "Crime"
        ],
        "tags": [],
        "added": "2024-09-24T22:02:33Z",
        "ratings": {
          "imdb": {
            "votes": 783236,
            "value": 7.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 11409,
            "value": 7.4,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 64,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 68,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 2,
          "relativePath": "American Psycho (2000).mp4",
          "path": "/movies/American Psycho (2000)/American Psycho (2000).mp4",
          "size": 1500134210,
          "dateAdded": "2024-09-24T22:47:21Z",
          "sceneName": "American Psyco (2000)",
          "releaseGroup": "YIFY",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 7,
              "name": "Bluray-1080p",
              "source": "bluray",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 96001,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "und",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 1860695,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x816",
            "runTime": "1:42:02",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "American Psyco (2000) 1080p/American.Psycho.2000.1080p.BrRip.x264.YIFY.mp4",
          "qualityCutoffNotMet": false,
          "id": 2
        },
        "collection": {
          "title": "American Psycho Collection",
          "tmdbId": 86105
        },
        "popularity": 10.2227,
        "lastSearchTime": "2024-09-24T23:03:50Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1500134210,
          "releaseGroups": [
            "YIFY"
          ]
        },
        "id": 2
      },
      {
        "title": "The Dark Knight",
        "originalTitle": "The Dark Knight",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "Batman: The Dark Knight",
            "id": 9
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "배트맨 다크 나이트",
            "id": 10
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "Batman, Le Chevalier Noir",
            "id": 11
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "Темный рыцарь",
            "id": 13
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "Mroczny Rycerz",
            "id": 15
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "Batman II: The Dark Knight",
            "id": 16
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "The Dark Knight 2: The Dark Knight",
            "id": 17
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "ダークナイト：2008",
            "id": 18
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "سوارچاكی تاریكی",
            "id": 19
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "El caballero oscuro",
            "id": 21
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "Hiệp Sĩ Bóng Đêm",
            "id": 22
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "Batman (El caballero oscuro) - 2. El caballero oscuro",
            "id": 23
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "შავი მხედარი",
            "id": 24
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "Խավարի Ասպետը",
            "id": 284
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 5,
            "title": "蝙蝠侠6：黑暗骑士",
            "id": 294
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "dark knight",
        "sizeOnDisk": 1828285704,
        "status": "released",
        "overview": "Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.",
        "inCinemas": "2008-07-16T00:00:00Z",
        "physicalRelease": "2008-10-22T00:00:00Z",
        "digitalRelease": "2011-01-29T00:00:00Z",
        "releaseDate": "2008-10-22T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/3/poster.jpg?lastWrite=638628139343766218",
            "remoteUrl": "https://image.tmdb.org/t/p/original/qJ2tW6WMUDux911r6m7haRef0WH.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/3/fanart.jpg?lastWrite=638843404294440139",
            "remoteUrl": "https://image.tmdb.org/t/p/original/enNubozHn9pXi0ycTVYUWfpHZm.jpg"
          }
        ],
        "website": "https://www.warnerbros.com/movies/dark-knight/",
        "year": 2008,
        "youTubeTrailerId": "_PZpmTj1Q8Q",
        "studio": "Warner Bros. Pictures",
        "path": "/movies/The Dark Knight (2008)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 1,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/The Dark Knight (2008)",
        "runtime": 152,
        "cleanTitle": "thedarkknight",
        "imdbId": "tt0468569",
        "tmdbId": 155,
        "titleSlug": "155",
        "rootFolderPath": "/movies/",
        "certification": "PG-13",
        "genres": [
          "Drama",
          "Action",
          "Crime",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-09-24T22:32:13Z",
        "ratings": {
          "imdb": {
            "votes": 3029582,
            "value": 9,
            "type": "user"
          },
          "tmdb": {
            "votes": 33939,
            "value": 8.52,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 84,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 94,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 3,
          "relativePath": "The Dark Knight (2008).mp4",
          "path": "/movies/The Dark Knight (2008)/The Dark Knight (2008).mp4",
          "size": 1828285704,
          "dateAdded": "2024-09-24T22:47:18Z",
          "sceneName": "Batman The Dark Knight (2008) [1080p]",
          "releaseGroup": "1080p",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 7,
              "name": "Bluray-1080p",
              "source": "bluray",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 63999,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "und",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 1534156,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:32:13",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "Batman The Dark Knight (2008) [1080p]/Batman.The.Dark.Knight.2008.1080p.BluRay.x264.YIFY.mp4",
          "qualityCutoffNotMet": false,
          "id": 1
        },
        "collection": {
          "title": "The Dark Knight Collection",
          "tmdbId": 263
        },
        "popularity": 23.0231,
        "lastSearchTime": "2024-09-24T23:04:10Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1828285704,
          "releaseGroups": [
            "1080p"
          ]
        },
        "id": 3
      },
      {
        "title": "Aavesham",
        "originalTitle": "ആവേശം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "aavesham",
        "sizeOnDisk": 1712961334,
        "status": "released",
        "overview": "Three college freshmen in Bangalore befriend an eccentric gangster to get revenge on their senior bullies.",
        "inCinemas": "2024-04-11T00:00:00Z",
        "digitalRelease": "2024-05-09T00:00:00Z",
        "releaseDate": "2024-05-09T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/4/poster.jpg?lastWrite=638798379655332320",
            "remoteUrl": "https://image.tmdb.org/t/p/original/k5RWPaNjgRcNvGoawYaQHQwyctI.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/4/fanart.jpg?lastWrite=638824393606086303",
            "remoteUrl": "https://image.tmdb.org/t/p/original/geUh6O5jBBBKsujZxbDCdpvZeRI.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Anwar Rasheed Entertainments",
        "path": "/movies/Aavesham (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 4,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Aavesham (2024)",
        "runtime": 158,
        "cleanTitle": "aavesham",
        "imdbId": "tt26660021",
        "tmdbId": 1084812,
        "titleSlug": "1084812",
        "rootFolderPath": "/movies/",
        "genres": [
          "Comedy",
          "Action"
        ],
        "tags": [],
        "added": "2024-09-24T23:04:18Z",
        "ratings": {
          "imdb": {
            "votes": 28441,
            "value": 7.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 62,
            "value": 7.4,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 4,
          "relativePath": "Aavesham (2024).mkv",
          "path": "/movies/Aavesham (2024)/Aavesham (2024).mkv",
          "size": 1712961334,
          "dateAdded": "2024-09-24T23:04:18Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "h265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:35:34",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": false,
          "id": 4
        },
        "popularity": 4.49,
        "lastSearchTime": "2024-09-24T23:04:37Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1712961334,
          "releaseGroups": []
        },
        "id": 4
      },
      {
        "title": "Anchakkallakokkan",
        "originalTitle": "അഞ്ചക്കള്ളക്കോക്കാൻ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 9,
            "title": "Chapra Murder Case",
            "id": 188
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "anchakkallakokkan",
        "sizeOnDisk": 1344430580,
        "status": "released",
        "overview": "In a small town, a cowardly police constable must survive his first days of duty when a convicted felon in lockup wishes to seek revenge.",
        "inCinemas": "2024-03-15T00:00:00Z",
        "releaseDate": "2024-06-13T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/5/poster.jpg?lastWrite=638821800890924443",
            "remoteUrl": "https://image.tmdb.org/t/p/original/zA9rFdbAK3Hz47jOahS16reFO0G.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/5/fanart.jpg?lastWrite=638821800893604650",
            "remoteUrl": "https://image.tmdb.org/t/p/original/hY15tZsPMxSZJhfsPbkCEcZMNxt.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Chembosky Motion Pictures",
        "path": "/movies/Anchakkallakokkan (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 5,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Anchakkallakokkan (2024)",
        "runtime": 126,
        "cleanTitle": "anchakkallakokkan",
        "imdbId": "tt29521808",
        "tmdbId": 1186391,
        "titleSlug": "1186391",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama",
          "Action",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-09-24T23:04:52Z",
        "ratings": {
          "imdb": {
            "votes": 1021,
            "value": 6.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 6,
            "value": 6.333,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 5,
          "relativePath": "Anchakkallakokkan (2024).mkv",
          "path": "/movies/Anchakkallakokkan (2024)/Anchakkallakokkan (2024).mkv",
          "size": 1344430580,
          "dateAdded": "2024-09-24T23:04:52Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "h265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:05:42",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "qualityCutoffNotMet": false,
          "id": 5
        },
        "popularity": 0.5088,
        "lastSearchTime": "2024-09-24T23:05:03Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1344430580,
          "releaseGroups": []
        },
        "id": 5
      },
      {
        "title": "Article 370",
        "originalTitle": "आर्टिकल 370",
        "originalLanguage": {
          "id": 26,
          "name": "Hindi"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "article 370",
        "sizeOnDisk": 3162660793,
        "status": "released",
        "overview": "Ahead of a major constitutional decision which rendered the Article 370 of the Indian state ineffective, special agent Zooni Haksar is tasked with a secret mission to quell violence in a conflict-ridden region.",
        "inCinemas": "2024-02-23T00:00:00Z",
        "digitalRelease": "2024-04-19T00:00:00Z",
        "releaseDate": "2024-04-19T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/6/poster.jpg?lastWrite=638823529347364678",
            "remoteUrl": "https://image.tmdb.org/t/p/original/9VTemjHMpyxzfC3JsG2aFy8Bf9Y.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/6/fanart.jpg?lastWrite=638628159061191172",
            "remoteUrl": "https://image.tmdb.org/t/p/original/ixX3aPr4rcCYFM0UsAH81T4eZ0e.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "B62 Studios",
        "path": "/movies/Article 370 (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 6,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Article 370 (2024)",
        "runtime": 160,
        "cleanTitle": "article370",
        "imdbId": "tt30970235",
        "tmdbId": 1233531,
        "titleSlug": "1233531",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama",
          "Action",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-09-24T23:05:05Z",
        "ratings": {
          "imdb": {
            "votes": 24870,
            "value": 7.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 28,
            "value": 6.5,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 83,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 6,
          "relativePath": "Article 370 (2024).mkv",
          "path": "/movies/Article 370 (2024)/Article 370 (2024).mkv",
          "size": 3162660793,
          "dateAdded": "2024-09-24T23:05:05Z",
          "edition": "",
          "languages": [
            {
              "id": 26,
              "name": "Hindi"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 5.1,
            "audioCodec": "AAC",
            "audioLanguages": "hin",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:36:30",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": false,
          "id": 6
        },
        "popularity": 1.2654,
        "lastSearchTime": "2024-09-24T23:05:12Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 3162660793,
          "releaseGroups": []
        },
        "id": 6
      },
      {
        "title": "Athomugam",
        "originalTitle": "அதோமுகம்",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 11,
            "title": "Adhomugam",
            "id": 26
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "athomugam",
        "sizeOnDisk": 1011456757,
        "status": "released",
        "overview": "Playful act of Martin by installing a spy app in his love of life Leena's phone reveals a mysterious character thereby triggering events that questions love, trust, friendship, technology and unravels the thrilling dark side of human actions.",
        "inCinemas": "2024-03-01T00:00:00Z",
        "releaseDate": "2024-05-30T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/7/poster.jpg?lastWrite=638813070618501649",
            "remoteUrl": "https://image.tmdb.org/t/p/original/Ad3ktJsF9saPUR3WiQ1zL40kfkN.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/7/fanart.jpg?lastWrite=638628159214563776",
            "remoteUrl": "https://image.tmdb.org/t/p/original/fhQXDsxSbqkC9s87F7ZXPP0eQtJ.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "",
        "path": "/movies/Athomugam (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 8,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Athomugam (2024)",
        "runtime": 130,
        "cleanTitle": "athomugam",
        "imdbId": "tt31124095",
        "tmdbId": 1254149,
        "titleSlug": "1254149",
        "rootFolderPath": "/movies/",
        "genres": [
          "Thriller",
          "Drama"
        ],
        "tags": [],
        "added": "2024-09-24T23:05:20Z",
        "ratings": {
          "imdb": {
            "votes": 633,
            "value": 7,
            "type": "user"
          },
          "tmdb": {
            "votes": 0,
            "value": 0,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 7,
          "relativePath": "Athomugham (2024).mkv",
          "path": "/movies/Athomugam (2024)/Athomugham (2024).mkv",
          "size": 1011456757,
          "dateAdded": "2024-09-24T23:11:42Z",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 5,
              "name": "WEBDL-720p",
              "source": "webdl",
              "resolution": 720,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "tam/tam",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1280x536",
            "runTime": "2:08:37",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "qualityCutoffNotMet": true,
          "id": 8
        },
        "popularity": 0.5622,
        "lastSearchTime": "2024-09-24T23:05:31Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1011456757,
          "releaseGroups": []
        },
        "id": 7
      },
      {
        "title": "Deadpool & Wolverine",
        "originalTitle": "Deadpool & Wolverine",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Quái Nhân Deadpool 3",
            "id": 27
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool 3",
            "id": 28
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Marvel Studios' Deadpool & Wolverine",
            "id": 29
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "ديدبول & وولفرين",
            "id": 30
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool y Wolverine",
            "id": 31
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool y Lobezno de Marvel Studios",
            "id": 32
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool und Wolverine",
            "id": 33
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Дэдпул 3",
            "id": 36
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Дедпул 3",
            "id": 40
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Tidal Wave",
            "id": 41
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Dedpul 3",
            "id": 42
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool en Wolverine",
            "id": 45
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool i Wolverine",
            "id": 46
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool 3 - Deadpool & Wolverine",
            "id": 207
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "דדפול ווולברין",
            "id": 221
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool e Wolverine",
            "id": 257
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool və Wolverine",
            "id": 259
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool et Wolverine",
            "id": 266
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Դեդպուլը և Լոգանը",
            "id": 285
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "死侍3：死侍与金刚狼",
            "id": 299
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool 3 - Deadpool et Wolverine",
            "id": 303
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpools & Wolverine",
            "id": 326
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Dogpool & Wolverine",
            "id": 327
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 12,
            "title": "Deadpool ja Wolverine",
            "id": 328
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "deadpool wolverine",
        "sizeOnDisk": 2754263461,
        "status": "released",
        "overview": "A listless Wade Wilson toils away in civilian life with his days as the morally flexible mercenary, Deadpool, behind him. But when his homeworld faces an existential threat, Wade must reluctantly suit-up again with an even more reluctant Wolverine.",
        "inCinemas": "2024-07-24T00:00:00Z",
        "physicalRelease": "2024-10-22T00:00:00Z",
        "digitalRelease": "2024-10-01T00:00:00Z",
        "releaseDate": "2024-10-01T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/8/poster.jpg?lastWrite=638704137783640519",
            "remoteUrl": "https://image.tmdb.org/t/p/original/8cdWjvZQUExUUTzyp4t6EDMubfO.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/8/fanart.jpg?lastWrite=638843404295520216",
            "remoteUrl": "https://image.tmdb.org/t/p/original/by8z9Fe8y7p4jo2YlW2SZDnptyT.jpg"
          }
        ],
        "website": "https://www.marvel.com/movies/deadpool-and-wolverine",
        "year": 2024,
        "youTubeTrailerId": "Idh8n5XuYIA",
        "studio": "Marvel Studios",
        "path": "/movies/Deadpool & Wolverine (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 29,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Deadpool & Wolverine (2024)",
        "runtime": 128,
        "cleanTitle": "deadpoolwolverine",
        "imdbId": "tt6263850",
        "tmdbId": 533535,
        "titleSlug": "533535",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Action",
          "Comedy",
          "Science Fiction"
        ],
        "tags": [],
        "added": "2024-09-24T23:07:58Z",
        "ratings": {
          "imdb": {
            "votes": 503897,
            "value": 7.5,
            "type": "user"
          },
          "tmdb": {
            "votes": 7337,
            "value": 7.595,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 56,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 78,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 8,
          "relativePath": "DeadPool And Wolverine (2024).mkv",
          "path": "/movies/Deadpool & Wolverine (2024)/DeadPool And Wolverine (2024).mkv",
          "size": 2754263461,
          "dateAdded": "2024-09-24T23:24:59Z",
          "edition": "",
          "languages": [
            {
              "id": 26,
              "name": "Hindi"
            },
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "hin/eng",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x780",
            "runTime": "2:08:37",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": false,
          "id": 29
        },
        "collection": {
          "title": "Deadpool Collection",
          "tmdbId": 448150
        },
        "popularity": 46.4046,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2754263461,
          "releaseGroups": []
        },
        "id": 8
      },
      {
        "title": "Despicable Me 4",
        "originalTitle": "Despicable Me 4",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "卑鄙的我4",
            "id": 47
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "من نفرت‌انگیز ۴",
            "id": 48
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "Moi, Moche et Méchant 4",
            "id": 49
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "Détestable Moi 4",
            "id": 50
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "Grusomme meg 4",
            "id": 51
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "İyrənc mən 4",
            "id": 52
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "Yaramaz Mən 4",
            "id": 53
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "Mi villano favorito 4",
            "id": 54
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "坏蛋奖门人4",
            "id": 55
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "Mina, Supervaras 4",
            "id": 220
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "Aulinn ég 4",
            "id": 260
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "神偷奶爸4",
            "id": 273
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 15,
            "title": "壞蛋獎門人4",
            "id": 302
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "despicable me 4",
        "sizeOnDisk": 1504407456,
        "status": "released",
        "overview": "Gru and Lucy and their girls—Margo, Edith and Agnes—welcome a new member to the Gru family, Gru Jr., who is intent on tormenting his dad. Gru also faces a new nemesis in Maxime Le Mal and his femme fatale girlfriend Valentina, forcing the family to go on the run.",
        "inCinemas": "2024-06-20T00:00:00Z",
        "physicalRelease": "2024-09-24T00:00:00Z",
        "digitalRelease": "2024-07-03T00:00:00Z",
        "releaseDate": "2024-07-03T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/9/poster.jpg?lastWrite=638714488803223616",
            "remoteUrl": "https://image.tmdb.org/t/p/original/wWba3TaojhK7NdycRhoQpsG0FaH.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/9/fanart.jpg?lastWrite=638765495730269735",
            "remoteUrl": "https://image.tmdb.org/t/p/original/lgkPzcOSnTvjeMnuFzozRO5HHw1.jpg"
          }
        ],
        "website": "https://www.despicable.me",
        "year": 2024,
        "youTubeTrailerId": "LtNYaH61dXY",
        "studio": "Universal Pictures",
        "path": "/movies/Despicable Me 4 (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 28,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Despicable Me 4 (2024)",
        "runtime": 94,
        "cleanTitle": "despicableme4",
        "imdbId": "tt7510222",
        "tmdbId": 519182,
        "titleSlug": "519182",
        "rootFolderPath": "/movies/",
        "certification": "PG",
        "genres": [
          "Animation",
          "Family",
          "Comedy",
          "Science Fiction"
        ],
        "tags": [],
        "added": "2024-09-24T23:08:35Z",
        "ratings": {
          "imdb": {
            "votes": 67634,
            "value": 6.2,
            "type": "user"
          },
          "tmdb": {
            "votes": 2795,
            "value": 7.039,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 52,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 56,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 9,
          "relativePath": "Despicable Me 4 (2024).mkv",
          "path": "/movies/Despicable Me 4 (2024)/Despicable Me 4 (2024).mkv",
          "size": 1504407456,
          "dateAdded": "2024-09-24T23:22:17Z",
          "releaseGroup": "Released",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 320000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1034",
            "runTime": "1:34:22",
            "scanType": "Progressive",
            "subtitles": "eng/eng"
          },
          "qualityCutoffNotMet": false,
          "id": 28
        },
        "collection": {
          "title": "Despicable Me Collection",
          "tmdbId": 86066
        },
        "popularity": 42.1039,
        "lastSearchTime": "2024-09-24T23:08:38Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1504407456,
          "releaseGroups": [
            "Released"
          ]
        },
        "id": 9
      },
      {
        "title": "Dune: Part Two",
        "originalTitle": "Dune: Part Two",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Dune 2",
            "id": 56
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Dune: Part 2",
            "id": 57
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "듄 2",
            "id": 58
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "デューン 砂の惑星PART2",
            "id": 59
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Duna 2",
            "id": 60
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Hành Tinh Cát 2",
            "id": 61
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Diuna: Część druga",
            "id": 62
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Duna: Parte Dois",
            "id": 63
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Kopa. II dalis",
            "id": 64
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Dune: Del 2",
            "id": 65
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Düün: teine osa",
            "id": 66
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Dune : Deuxième Partie",
            "id": 67
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Dűne: Második rész",
            "id": 68
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "ड्यून पार्ट टू",
            "id": 69
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Kopa. Antra dalis",
            "id": 70
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Дюна: Часть 2",
            "id": 71
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Дина 2",
            "id": 72
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "沙丘：第二部",
            "id": 73
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Дюна 2",
            "id": 74
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Duna: Parte 2",
            "id": 75
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Dune Two",
            "id": 76
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Dyyni: Osa kaksi",
            "id": 77
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "沙丘2",
            "id": 78
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "Hành Tinh Cát II",
            "id": 79
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "듄: 파트 2",
            "id": 80
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "დიუნი: ნაწილი ორი",
            "id": 230
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 19,
            "title": "沙丘瀚戰：第二章",
            "id": 265
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "dune part two",
        "sizeOnDisk": 1723332583,
        "status": "released",
        "overview": "Follow the mythic journey of Paul Atreides as he unites with Chani and the Fremen while on a path of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the known universe, Paul endeavors to prevent a terrible future only he can foresee.",
        "inCinemas": "2024-02-27T00:00:00Z",
        "physicalRelease": "2024-05-14T00:00:00Z",
        "digitalRelease": "2024-02-06T00:00:00Z",
        "releaseDate": "2024-02-06T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/10/poster.jpg?lastWrite=638847724724292910",
            "remoteUrl": "https://image.tmdb.org/t/p/original/6izwz7rsy95ARzTR3poZ8H6c5pp.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/10/fanart.jpg?lastWrite=638775001369976114",
            "remoteUrl": "https://image.tmdb.org/t/p/original/xOMo8BRK7PfcJv9JCnx7s5hj0PX.jpg"
          }
        ],
        "website": "https://www.dunemovie.com",
        "year": 2024,
        "youTubeTrailerId": "U2Qp5pL3ovA",
        "studio": "Legendary Pictures",
        "path": "/movies/Dune Part Two (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 9,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Dune Part Two (2024)",
        "runtime": 167,
        "cleanTitle": "duneparttwo",
        "imdbId": "tt15239678",
        "tmdbId": 693134,
        "titleSlug": "693134",
        "rootFolderPath": "/movies/",
        "certification": "PG-13",
        "genres": [
          "Science Fiction",
          "Adventure"
        ],
        "tags": [],
        "added": "2024-09-24T23:13:05Z",
        "ratings": {
          "imdb": {
            "votes": 638128,
            "value": 8.5,
            "type": "user"
          },
          "tmdb": {
            "votes": 6722,
            "value": 8.148,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 79,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 92,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 10,
          "relativePath": "Dune Part Two (2024).mkv",
          "path": "/movies/Dune Part Two (2024)/Dune Part Two (2024).mkv",
          "size": 1723332583,
          "dateAdded": "2024-09-24T23:13:06Z",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 320000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:45:47",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "qualityCutoffNotMet": false,
          "id": 9
        },
        "collection": {
          "title": "Dune Collection",
          "tmdbId": 726871
        },
        "popularity": 66.3206,
        "lastSearchTime": "2024-09-24T23:13:12Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1723332583,
          "releaseGroups": []
        },
        "id": 10
      },
      {
        "title": "The Fall Guy",
        "originalTitle": "The Fall Guy",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 22,
            "title": "Le Cascadeur",
            "id": 82
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 22,
            "title": "Каскадер",
            "id": 83
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 22,
            "title": "特技狂人",
            "id": 84
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 22,
            "title": "Kaskadyor",
            "id": 85
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 22,
            "title": "L'homme qui tombe à pic",
            "id": 86
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 22,
            "title": "The Fall Guy: The Extended Cut",
            "id": 87
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 22,
            "title": "特技玩家",
            "id": 274
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "fall guy",
        "sizeOnDisk": 1505973852,
        "status": "released",
        "overview": "Fresh off an almost career-ending accident, stuntman Colt Seavers has to track down a missing movie star, solve a conspiracy and try to win back the love of his life while still doing his day job.",
        "inCinemas": "2024-04-24T00:00:00Z",
        "physicalRelease": "2024-07-23T00:00:00Z",
        "digitalRelease": "2024-05-20T00:00:00Z",
        "releaseDate": "2024-05-20T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/11/poster.jpg?lastWrite=638803564143324909",
            "remoteUrl": "https://image.tmdb.org/t/p/original/e7olqFmzcIX5c23kX4zSmLPJi8c.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/11/fanart.jpg?lastWrite=638826986205293104",
            "remoteUrl": "https://image.tmdb.org/t/p/original/H5HjE7Xb9N09rbWn1zBfxgI8uz.jpg"
          }
        ],
        "website": "https://www.thefallguymovie.com",
        "year": 2024,
        "youTubeTrailerId": "EySdVK0NK1Y",
        "studio": "87North Productions",
        "path": "/movies/The Fall Guy (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 10,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/The Fall Guy (2024)",
        "runtime": 127,
        "cleanTitle": "thefallguy",
        "imdbId": "tt1684562",
        "tmdbId": 746036,
        "titleSlug": "746036",
        "rootFolderPath": "/movies/",
        "certification": "PG-13",
        "genres": [
          "Action",
          "Comedy"
        ],
        "tags": [],
        "added": "2024-09-24T23:13:16Z",
        "ratings": {
          "imdb": {
            "votes": 225073,
            "value": 6.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 3010,
            "value": 7.02,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 73,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 81,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 11,
          "relativePath": "The Fall Guy (2024).mkv",
          "path": "/movies/The Fall Guy (2024)/The Fall Guy (2024).mkv",
          "size": 1505973852,
          "dateAdded": "2024-09-24T23:13:16Z",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 320000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:07:02",
            "scanType": "Progressive",
            "subtitles": "eng/eng/spa/fre"
          },
          "qualityCutoffNotMet": false,
          "id": 10
        },
        "popularity": 14.1856,
        "lastSearchTime": "2024-09-24T23:13:23Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1505973852,
          "releaseGroups": []
        },
        "id": 11
      },
      {
        "title": "Fight Club",
        "originalTitle": "Fight Club",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "Mo'adon Krav",
            "id": 88
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "Borilački klub",
            "id": 89
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "Boytsovskiy klub",
            "id": 90
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "Boen klub",
            "id": 91
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "Biytsivsʹkyy klub",
            "id": 93
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "Байцоўскі клюб",
            "id": 210
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "Döyüshçü Klubu",
            "id": 211
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "მალჷმორეფიშ კლუბი",
            "id": 212
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "Մարտական ակումբ",
            "id": 213
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "النادي د لمدابزة",
            "id": 214
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "نادى القتال",
            "id": 215
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "Мушташ клубу",
            "id": 216
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "فایت کلاب",
            "id": 217
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "फाइट क्लब",
            "id": 218
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "ਫ਼ਾਈਟ ਕਲੱਬ",
            "id": 219
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "搏击会",
            "id": 258
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "鬥陣俱樂部",
            "id": 275
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 23,
            "title": "Մարտ Ակումբ",
            "id": 287
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "fight club",
        "sizeOnDisk": 1987772924,
        "status": "released",
        "overview": "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
        "inCinemas": "1999-10-15T00:00:00Z",
        "physicalRelease": "2000-04-25T00:00:00Z",
        "digitalRelease": "2011-09-08T00:00:00Z",
        "releaseDate": "2000-04-25T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/12/poster.jpg?lastWrite=638730929883210284",
            "remoteUrl": "https://image.tmdb.org/t/p/original/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/12/fanart.jpg?lastWrite=638833035354507448",
            "remoteUrl": "https://image.tmdb.org/t/p/original/xRyINp9KfMLVjRiO5nCsoRDdvvF.jpg"
          }
        ],
        "website": "http://www.foxmovies.com/movies/fight-club",
        "year": 1999,
        "youTubeTrailerId": "dfeUzm6KF4g",
        "studio": "Fox 2000 Pictures",
        "path": "/movies/Fight Club (1999)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 11,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Fight Club (1999)",
        "runtime": 139,
        "cleanTitle": "fightclub",
        "imdbId": "tt0137523",
        "tmdbId": 550,
        "titleSlug": "550",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Drama"
        ],
        "tags": [],
        "added": "2024-09-24T23:13:23Z",
        "ratings": {
          "imdb": {
            "votes": 2469777,
            "value": 8.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 30331,
            "value": 8.437,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 67,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 81,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 12,
          "relativePath": "Fight Club (1999).mp4",
          "path": "/movies/Fight Club (1999)/Fight Club (1999).mp4",
          "size": 1987772924,
          "dateAdded": "2024-09-24T23:13:23Z",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 9,
              "name": "HDTV-1080p",
              "source": "tv",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 95968,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 1805154,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:19:08",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "qualityCutoffNotMet": false,
          "id": 11
        },
        "popularity": 27.6245,
        "lastSearchTime": "2024-09-24T23:13:31Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1987772924,
          "releaseGroups": []
        },
        "id": 12
      },
      {
        "title": "Golam",
        "originalTitle": "ഗോളം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "golam",
        "sizeOnDisk": 1031155992,
        "status": "released",
        "overview": "A mysterious death during work hours in an office puzzles all but only Investigator ASP Sandeep Krishna observes it as a murder.",
        "inCinemas": "2024-06-07T00:00:00Z",
        "releaseDate": "2024-09-05T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/13/poster.jpg?lastWrite=638845132526436627",
            "remoteUrl": "https://image.tmdb.org/t/p/original/Aa30QzjokChiDOtuV27cfOSSVOA.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/13/fanart.jpg?lastWrite=638640190438746804",
            "remoteUrl": "https://image.tmdb.org/t/p/original/ra2T4rF5lbO58zKFF36f1zia93d.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "vL6l-9OqmfU",
        "studio": "Fragrant Nature Film Creations",
        "path": "/movies/Golam (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 22,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Golam (2024)",
        "runtime": 119,
        "cleanTitle": "golam",
        "imdbId": "tt29272469",
        "tmdbId": 1222140,
        "titleSlug": "1222140",
        "rootFolderPath": "/movies/",
        "genres": [
          "Crime"
        ],
        "tags": [],
        "added": "2024-09-24T23:13:29Z",
        "ratings": {
          "imdb": {
            "votes": 5676,
            "value": 7.2,
            "type": "user"
          },
          "tmdb": {
            "votes": 14,
            "value": 6.214,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 13,
          "relativePath": "Golam.mkv",
          "path": "/movies/Golam (2024)/Golam.mkv",
          "size": 1031155992,
          "dateAdded": "2024-09-24T23:19:08Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "h265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "1:58:19",
            "scanType": "Progressive",
            "subtitles": "eng/eng"
          },
          "qualityCutoffNotMet": false,
          "id": 22
        },
        "popularity": 1.077,
        "lastSearchTime": "2024-09-24T23:13:43Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1031155992,
          "releaseGroups": []
        },
        "id": 13
      },
      {
        "title": "Guruvayoorambala Nadayil",
        "originalTitle": "ഗുരുവായൂരമ്പല നടയിൽ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "guruvayoorambala nadayil",
        "sizeOnDisk": 1780809315,
        "status": "released",
        "overview": "Vinu, who is still grieving over his breakup from five years ago, develops a strong relationship with Anandan, his prospective brother-in-law, but his attempts to resolve Anandan's problems have some unexpected consequences.",
        "inCinemas": "2024-05-16T00:00:00Z",
        "releaseDate": "2024-08-14T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/14/poster.jpg?lastWrite=638628164187057335",
            "remoteUrl": "https://image.tmdb.org/t/p/original/7L7QI2PlPPF8yAW9YrjfRwJeoDV.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/14/fanart.jpg?lastWrite=638628164188137425",
            "remoteUrl": "https://image.tmdb.org/t/p/original/bYNO2cFopBEwnVNWPEtFm2FAdjo.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Prithviraj Productions",
        "path": "/movies/Guruvayoorambala Nadayil (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 23,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Guruvayoorambala Nadayil (2024)",
        "runtime": 132,
        "cleanTitle": "guruvayoorambalanadayil",
        "imdbId": "tt25400540",
        "tmdbId": 1068394,
        "titleSlug": "1068394",
        "rootFolderPath": "/movies/",
        "genres": [
          "Comedy"
        ],
        "tags": [],
        "added": "2024-09-24T23:13:38Z",
        "ratings": {
          "imdb": {
            "votes": 4771,
            "value": 6.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 21,
            "value": 5.81,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 60,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 14,
          "relativePath": "Guruvayoor Ambalanadayil (2024).mkv",
          "path": "/movies/Guruvayoorambala Nadayil (2024)/Guruvayoor Ambalanadayil (2024).mkv",
          "size": 1780809315,
          "dateAdded": "2024-09-24T23:19:52Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:13:09",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": false,
          "id": 23
        },
        "popularity": 0.6255,
        "lastSearchTime": "2024-09-24T23:13:51Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1780809315,
          "releaseGroups": []
        },
        "id": 14
      },
      {
        "title": "HIT: The 2nd Case",
        "originalTitle": "హిట్: ది సెకండ్ కేస్",
        "originalLanguage": {
          "id": 45,
          "name": "Telugu"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 26,
            "title": "HIT : The Second Case",
            "id": 107
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 26,
            "title": "Hit 2",
            "id": 108
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 26,
            "title": "Hit: Case 2",
            "id": 109
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "hit 2nd case",
        "sizeOnDisk": 1053425942,
        "status": "released",
        "overview": "Krishna Dev aka KD, a laidback cop working in Andhra Pradesh State HIT, takes on a gruesome murder case. As KD unravels the layers of the crime, the stakes rise unbelievably high and the threat comes unusually close.",
        "inCinemas": "2022-12-01T00:00:00Z",
        "releaseDate": "2023-03-01T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/15/poster.jpg?lastWrite=638814799111068233",
            "remoteUrl": "https://image.tmdb.org/t/p/original/tidXGOilCSa5sch1KGiEXrWeYCf.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/15/fanart.jpg?lastWrite=638814799112788403",
            "remoteUrl": "https://image.tmdb.org/t/p/original/aHtZFBjUCSpghKWl2rU7zP6FhRQ.jpg"
          }
        ],
        "website": "",
        "year": 2022,
        "youTubeTrailerId": "",
        "studio": "Wall Poster Cinema",
        "path": "/movies/HIT The Second Case (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 21,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/HIT The Second Case (2024)",
        "runtime": 124,
        "cleanTitle": "hit2ndcase",
        "imdbId": "tt14279982",
        "tmdbId": 811945,
        "titleSlug": "811945",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Crime",
          "Thriller",
          "Action"
        ],
        "tags": [],
        "added": "2024-09-24T23:13:51Z",
        "ratings": {
          "imdb": {
            "votes": 7997,
            "value": 7.2,
            "type": "user"
          },
          "tmdb": {
            "votes": 28,
            "value": 6.9,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 15,
          "relativePath": "HIT The Second Case (2024).mkv",
          "path": "/movies/HIT The Second Case (2024)/HIT The Second Case (2024).mkv",
          "size": 1053425942,
          "dateAdded": "2024-09-24T23:17:53Z",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            },
            {
              "id": 45,
              "name": "Telugu"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "tam/tel",
            "audioStreamCount": 3,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "h265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "1:57:45",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "qualityCutoffNotMet": false,
          "id": 21
        },
        "collection": {
          "title": "HIT Verse",
          "tmdbId": 918344
        },
        "popularity": 3.8263,
        "lastSearchTime": "2024-09-24T23:17:56Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1053425942,
          "releaseGroups": []
        },
        "id": 15
      },
      {
        "title": "Inside Out 2",
        "originalTitle": "Inside Out 2",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Disney and Pixar's Inside Out 2",
            "id": 110
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Ters Yüz 2",
            "id": 111
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Думками навиворіт 2",
            "id": 112
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "玩轉腦朋友 2",
            "id": 113
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "درون و بیرون ۲",
            "id": 114
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "IntensaMente 2",
            "id": 115
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Τα μυαλά που κουβαλάς 2",
            "id": 116
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Tapmaca 2",
            "id": 117
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Навыварат 2",
            "id": 118
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Divertida Mente 2",
            "id": 119
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Отвътре навън 2",
            "id": 120
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "V hlavě 2",
            "id": 121
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Inderst inde 2",
            "id": 122
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Pahupidi 2",
            "id": 123
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Inside Out - mielen sopukoissa 2",
            "id": 124
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Agymanók 2.",
            "id": 125
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Daroon va Biroon 2",
            "id": 126
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Ойжұмбақ 2",
            "id": 128
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Баш катырма 2",
            "id": 129
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Binnenstebuiten 2",
            "id": 130
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "W głowie się nie mieści 2",
            "id": 131
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Întors pe dos 2",
            "id": 132
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Головоломка 2",
            "id": 133
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Vrvež v moji glavi 2",
            "id": 134
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Insaideu aus 2",
            "id": 135
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Del revés 2",
            "id": 136
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Insidan ut 2",
            "id": 137
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "腦筋急轉彎2",
            "id": 138
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Boshqotirma 2",
            "id": 139
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Những Mảnh Ghép Cảm Xúc 2",
            "id": 140
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Anndan De",
            "id": 141
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "头脑特工队2",
            "id": 142
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Sens dessus dessous 2",
            "id": 144
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Vice-Versa 2",
            "id": 145
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "Вэрхал у галаве 2",
            "id": 146
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "divertidamente",
            "id": 262
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 29,
            "title": "インサイドヘッド２",
            "id": 264
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "inside out 2",
        "sizeOnDisk": 2448779631,
        "status": "released",
        "overview": "Teenager Riley's mind headquarters is undergoing a sudden demolition to make room for something entirely unexpected: new Emotions! Joy, Sadness, Anger, Fear and Disgust, who’ve long been running a successful operation by all accounts, aren’t sure how to feel when Anxiety shows up. And it looks like she’s not alone.",
        "inCinemas": "2024-06-11T00:00:00Z",
        "physicalRelease": "2024-09-10T00:00:00Z",
        "digitalRelease": "2024-08-19T00:00:00Z",
        "releaseDate": "2024-08-19T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/16/poster.jpg?lastWrite=638705866101931348",
            "remoteUrl": "https://image.tmdb.org/t/p/original/vpnVM9B6NMmQpWeZvzLvDESb2QY.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/16/fanart.jpg?lastWrite=638692039958284348",
            "remoteUrl": "https://image.tmdb.org/t/p/original/p5ozvmdgsmbWe0H8Xk7Rc8SCwAB.jpg"
          }
        ],
        "website": "https://movies.disney.com/inside-out-2",
        "year": 2024,
        "youTubeTrailerId": "u69y5Ie519M",
        "studio": "Walt Disney Pictures",
        "path": "/movies/Inside Out 2 (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 12,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Inside Out 2 (2024)",
        "runtime": 97,
        "cleanTitle": "insideout2",
        "imdbId": "tt22022452",
        "tmdbId": 1022789,
        "titleSlug": "1022789",
        "rootFolderPath": "/movies/",
        "certification": "PG",
        "genres": [
          "Animation",
          "Adventure",
          "Comedy",
          "Family"
        ],
        "tags": [],
        "added": "2024-09-24T23:14:01Z",
        "ratings": {
          "imdb": {
            "votes": 220404,
            "value": 7.5,
            "type": "user"
          },
          "tmdb": {
            "votes": 5897,
            "value": 7.554,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 73,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 91,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 16,
          "relativePath": "Inside Out 2 (2024).mkv",
          "path": "/movies/Inside Out 2 (2024)/Inside Out 2 (2024).mkv",
          "size": 2448779631,
          "dateAdded": "2024-09-24T23:14:01Z",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 768000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3 Atmos",
            "audioLanguages": "eng/eng",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1912x800",
            "runTime": "1:36:20",
            "scanType": "Progressive",
            "subtitles": "eng/eng"
          },
          "qualityCutoffNotMet": false,
          "id": 12
        },
        "collection": {
          "title": "Inside Out Collection",
          "tmdbId": 1022790
        },
        "popularity": 41.5177,
        "lastSearchTime": "2024-09-24T23:14:06Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2448779631,
          "releaseGroups": []
        },
        "id": 16
      },
      {
        "title": "Kalki 2898-AD",
        "originalTitle": "కల్కి 2898-ఎ.డి",
        "originalLanguage": {
          "id": 45,
          "name": "Telugu"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 31,
            "title": "Project K",
            "id": 147
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 31,
            "title": "Kalki",
            "id": 148
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 31,
            "title": "Prabhas 21",
            "id": 149
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 31,
            "title": "Шамбала. Конец времён",
            "id": 208
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 31,
            "title": "Калки, 2898 год нашей эры",
            "id": 228
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "kalki 2898 ad",
        "sizeOnDisk": 1764724970,
        "status": "released",
        "overview": "In the year 2898 AD, around 6000 years after Kurukshetra war, Ashwatthama gears up for his final battle of redemption at the sign of hope in a dystopian world and Bhairava, a wisecracking and self-interested bounty hunter, tired of the perilous life becomes the hurdle in the process.",
        "inCinemas": "2024-06-26T00:00:00Z",
        "physicalRelease": "2024-08-21T00:00:00Z",
        "digitalRelease": "2024-08-22T00:00:00Z",
        "releaseDate": "2024-08-21T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/17/poster.jpg?lastWrite=638846860675205499",
            "remoteUrl": "https://image.tmdb.org/t/p/original/rstcAnBeCkxNQjNp3YXrF6IP1tW.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/17/fanart.jpg?lastWrite=638817480102645734",
            "remoteUrl": "https://image.tmdb.org/t/p/original/o8XSR1SONnjcsv84NRu6Mwsl5io.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "rn7tdg6cpW4",
        "studio": "Vyjayanthi Movies",
        "path": "/movies/Kalki 2898-AD (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 24,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Kalki 2898-AD (2024)",
        "runtime": 176,
        "cleanTitle": "kalki2898ad",
        "imdbId": "tt12735488",
        "tmdbId": 801688,
        "titleSlug": "801688",
        "rootFolderPath": "/movies/",
        "certification": "PG-13",
        "genres": [
          "Drama",
          "Action",
          "Fantasy",
          "Science Fiction"
        ],
        "tags": [],
        "added": "2024-09-24T23:14:11Z",
        "ratings": {
          "imdb": {
            "votes": 67652,
            "value": 7,
            "type": "user"
          },
          "tmdb": {
            "votes": 125,
            "value": 6.5,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 65,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 77,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 17,
          "relativePath": "Kalki 2898 AD (2024).mkv",
          "path": "/movies/Kalki 2898-AD (2024)/Kalki 2898 AD (2024).mkv",
          "size": 1764724970,
          "dateAdded": "2024-09-24T23:20:19Z",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "tam/tam",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "h265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:55:45",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": false,
          "id": 24
        },
        "collection": {
          "title": "Kalki Collection",
          "tmdbId": 1310970
        },
        "popularity": 7.7886,
        "lastSearchTime": "2024-09-24T23:14:17Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1764724970,
          "releaseGroups": []
        },
        "id": 17
      },
      {
        "title": "Maheshinte Prathikaaram",
        "originalTitle": "മഹേഷിന്‍റെ പ്രതികാരം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 33,
            "title": "Maheshinte Prathikaram",
            "id": 150
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 33,
            "title": "Mahesh's Revenge",
            "id": 151
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "maheshinte prathikaaram",
        "sizeOnDisk": 2808590120,
        "status": "released",
        "overview": "Mahesh, a studio photographer and owner of the studio. As the story moves on, Mahesh encounters an anonymous fight ending up with taking revenge that leads to certain realizations in his life.",
        "inCinemas": "2016-02-05T00:00:00Z",
        "physicalRelease": "2016-05-10T00:00:00Z",
        "releaseDate": "2016-05-10T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/18/poster.jpg?lastWrite=638821800914726279",
            "remoteUrl": "https://image.tmdb.org/t/p/original/hmK9QUWpOaSs1H7tarzlMNqT60H.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/18/fanart.jpg?lastWrite=638821800916526417",
            "remoteUrl": "https://image.tmdb.org/t/p/original/58m1VAHe27SkqRnNdR2rxkqVnWS.jpg"
          }
        ],
        "website": "",
        "year": 2016,
        "youTubeTrailerId": "_KY8Du4WWew",
        "studio": "OPM Dream Mill Cinemas",
        "path": "/movies/Maheshinte Prathikaaram (2016)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 25,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Maheshinte Prathikaaram (2016)",
        "runtime": 121,
        "cleanTitle": "maheshinteprathikaaram",
        "imdbId": "tt4851630",
        "tmdbId": 381691,
        "titleSlug": "381691",
        "rootFolderPath": "/movies/",
        "certification": "PG",
        "genres": [
          "Comedy",
          "Drama"
        ],
        "tags": [],
        "added": "2024-09-24T23:14:19Z",
        "ratings": {
          "imdb": {
            "votes": 11250,
            "value": 8.3,
            "type": "user"
          },
          "tmdb": {
            "votes": 67,
            "value": 7.7,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 18,
          "relativePath": "Maheshinte Prathikaram (2016).mp4",
          "path": "/movies/Maheshinte Prathikaaram (2016)/Maheshinte Prathikaram (2016).mp4",
          "size": 2808590120,
          "dateAdded": "2024-09-24T23:20:43Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 9,
              "name": "HDTV-1080p",
              "source": "tv",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 253375,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "und",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 2868234,
            "videoCodec": "x264",
            "videoFps": 25,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "1:59:44",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "qualityCutoffNotMet": false,
          "id": 25
        },
        "popularity": 2.0457,
        "lastSearchTime": "2024-09-24T23:14:32Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2808590120,
          "releaseGroups": []
        },
        "id": 18
      },
      {
        "title": "Malayalee from India",
        "originalTitle": "മലയാളി ഫ്രം ഇന്ത്യ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 34,
            "title": "NP43",
            "id": 152
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 34,
            "title": "Nivin Pauly 43",
            "id": 153
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 34,
            "title": "MFI",
            "id": 154
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "malayalee from india",
        "sizeOnDisk": 1706575981,
        "status": "released",
        "overview": "Aalparambil Gopi, an unemployed boy, is forced to travel away from home. Fortunately, the journey ends up transforming his life forever.",
        "inCinemas": "2024-05-01T00:00:00Z",
        "releaseDate": "2024-07-30T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/19/poster.jpg?lastWrite=638825257764547126",
            "remoteUrl": "https://image.tmdb.org/t/p/original/mOqYSsuaDi9D6dh0GRF8gj2ilJQ.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/19/fanart.jpg?lastWrite=638825257765507198",
            "remoteUrl": "https://image.tmdb.org/t/p/original/fP6hZm95w8AK6l8CRAAhLGkh5WV.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "U8AEj9DN1wo",
        "studio": "Magic Frames",
        "path": "/movies/Malayalee from India (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 26,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Malayalee from India (2024)",
        "runtime": 158,
        "cleanTitle": "malayaleefromindia",
        "imdbId": "tt26655359",
        "tmdbId": 1101175,
        "titleSlug": "1101175",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama",
          "Comedy"
        ],
        "tags": [],
        "added": "2024-09-24T23:14:26Z",
        "ratings": {
          "imdb": {
            "votes": 4992,
            "value": 5.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 5,
            "value": 4.5,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 19,
          "relativePath": "Malayalee From India (2024).mkv",
          "path": "/movies/Malayalee from India (2024)/Malayalee From India (2024).mkv",
          "size": 1706575981,
          "dateAdded": "2024-09-24T23:21:00Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:35:30",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": false,
          "id": 26
        },
        "popularity": 0.3761,
        "lastSearchTime": "2024-09-24T23:14:54Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1706575981,
          "releaseGroups": []
        },
        "id": 19
      },
      {
        "title": "Manjummel Boys",
        "originalTitle": "മഞ്ഞുമ്മല്‍ BOYS",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 35,
            "title": "Manjummal Boys",
            "id": 155
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 35,
            "title": "冒险之旅",
            "id": 156
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "manjummel boys",
        "sizeOnDisk": 1742388684,
        "status": "released",
        "overview": "Manjummel Boys, based on a real story, is about a bunch of friends who set out on a trip to Kodaikanal and the events that occur there.",
        "inCinemas": "2024-02-22T00:00:00Z",
        "digitalRelease": "2024-05-05T00:00:00Z",
        "releaseDate": "2024-05-05T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/20/poster.jpg?lastWrite=638788828009927039",
            "remoteUrl": "https://image.tmdb.org/t/p/original/bswrtewwthpsh6nABiqKevU4UBI.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/20/fanart.jpg?lastWrite=638823529354085222",
            "remoteUrl": "https://image.tmdb.org/t/p/original/zGsHpuMN412VyzJZZnQeq4lMdjF.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "9uzfrur9SDU",
        "studio": "Parava Films",
        "path": "/movies/Manjummel Boys (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 13,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Manjummel Boys (2024)",
        "runtime": 135,
        "cleanTitle": "manjummelboys",
        "imdbId": "tt26458038",
        "tmdbId": 1069945,
        "titleSlug": "1069945",
        "rootFolderPath": "/movies/",
        "genres": [
          "Adventure",
          "Thriller",
          "Drama"
        ],
        "tags": [],
        "added": "2024-09-24T23:14:33Z",
        "ratings": {
          "imdb": {
            "votes": 27475,
            "value": 8.2,
            "type": "user"
          },
          "tmdb": {
            "votes": 53,
            "value": 7.66,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 20,
          "relativePath": "Manjummel Boys (2024).mkv",
          "path": "/movies/Manjummel Boys (2024)/Manjummel Boys (2024).mkv",
          "size": 1742388684,
          "dateAdded": "2024-09-24T23:14:33Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1012",
            "runTime": "2:14:22",
            "scanType": "Progressive",
            "subtitles": "eng/eng/eng/eng"
          },
          "qualityCutoffNotMet": false,
          "id": 13
        },
        "popularity": 1.5272,
        "lastSearchTime": "2024-09-24T23:15:02Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1742388684,
          "releaseGroups": []
        },
        "id": 20
      },
      {
        "title": "Monkey Man",
        "originalTitle": "Monkey Man",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 36,
            "title": "Taurus",
            "id": 157
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 36,
            "title": "मंकी मैन",
            "id": 158
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 36,
            "title": "L'homme singe",
            "id": 159
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 36,
            "title": "مرد میمون‌نما",
            "id": 160
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 36,
            "title": "'Ish Ha'Kof",
            "id": 161
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 36,
            "title": "Monkey Man: El Despertar De La Bestia",
            "id": 162
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "monkey man",
        "sizeOnDisk": 1505044864,
        "status": "released",
        "overview": "Kid is an anonymous young man who ekes out a meager living in an underground fight club where, night after night, wearing a gorilla mask, he is beaten bloody by more popular fighters for cash. After years of suppressed rage, Kid discovers a way to infiltrate the enclave of the city’s sinister elite. As his childhood trauma boils over, his mysteriously scarred hands unleash an explosive campaign of retribution to settle the score with the men who took everything from him.",
        "inCinemas": "2024-04-03T00:00:00Z",
        "physicalRelease": "2024-06-25T00:00:00Z",
        "digitalRelease": "2024-04-05T00:00:00Z",
        "releaseDate": "2024-04-05T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/21/poster.jpg?lastWrite=638795787418955978",
            "remoteUrl": "https://image.tmdb.org/t/p/original/4lhR4L2vzzjl68P1zJyCH755Oz4.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/21/fanart.jpg?lastWrite=638820936690020499",
            "remoteUrl": "https://image.tmdb.org/t/p/original/9NSXdVHeSfSHUv49OzLispFcpz1.jpg"
          }
        ],
        "website": "https://www.monkeyman.movie",
        "year": 2024,
        "youTubeTrailerId": "aqa3YTtwvaU",
        "studio": "Thunder Road",
        "path": "/movies/Monkey Man (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 14,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Monkey Man (2024)",
        "runtime": 121,
        "cleanTitle": "monkeyman",
        "imdbId": "tt9214772",
        "tmdbId": 560016,
        "titleSlug": "560016",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Action",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-09-24T23:14:41Z",
        "ratings": {
          "imdb": {
            "votes": 93054,
            "value": 6.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 1142,
            "value": 6.9,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 70,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 89,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 21,
          "relativePath": "Monkey Man (2024).mkv",
          "path": "/movies/Monkey Man (2024)/Monkey Man (2024).mkv",
          "size": 1505044864,
          "dateAdded": "2024-09-24T23:14:41Z",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 320000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:01:45",
            "scanType": "Progressive",
            "subtitles": "eng/eng/eng"
          },
          "qualityCutoffNotMet": false,
          "id": 14
        },
        "popularity": 5.7749,
        "lastSearchTime": "2024-09-24T23:15:04Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1505044864,
          "releaseGroups": []
        },
        "id": 21
      },
      {
        "title": "North 24 Kaatham",
        "originalTitle": "നോർത്ത് 24 കാതം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 37,
            "title": "North 24 Katham",
            "id": 163
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "north 24 kaatham",
        "sizeOnDisk": 944829422,
        "status": "released",
        "overview": "Harikrishnan is a geeky software professional who suffers from an obsessive compulsive disorder. A harthal day sees him travelling to Trivandrum for a conference, and in the midst of the night, he ends up at Paravur railway station with two strangers - Gopalan  a veteran politician and Narayani a social worker - for company.",
        "inCinemas": "2013-09-14T00:00:00Z",
        "releaseDate": "2013-12-13T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/22/poster.jpg?lastWrite=638804428319733391",
            "remoteUrl": "https://image.tmdb.org/t/p/original/p5mmJFoAch1GxGpy2HMQ9M0eQ16.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/22/fanart.jpg?lastWrite=638804428323493666",
            "remoteUrl": "https://image.tmdb.org/t/p/original/ylq2JH1WSdvGrR9iqmHHDnAcfRs.jpg"
          }
        ],
        "website": "",
        "year": 2013,
        "youTubeTrailerId": "xbA6X0qCj8I",
        "studio": "E4 Entertainments",
        "path": "/movies/North 24 Kaatham (2013)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 15,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/North 24 Kaatham (2013)",
        "runtime": 125,
        "cleanTitle": "north24kaatham",
        "imdbId": "tt3198468",
        "tmdbId": 224057,
        "titleSlug": "224057",
        "rootFolderPath": "/movies/",
        "genres": [
          "Adventure",
          "Comedy",
          "Family"
        ],
        "tags": [],
        "added": "2024-09-24T23:14:55Z",
        "ratings": {
          "imdb": {
            "votes": 3461,
            "value": 7.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 37,
            "value": 7.6,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 22,
          "relativePath": "North 24 Kaatham (2013).mp4",
          "path": "/movies/North 24 Kaatham (2013)/North 24 Kaatham (2013).mp4",
          "size": 944829422,
          "dateAdded": "2024-09-24T23:14:55Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 1,
              "name": "SDTV",
              "source": "tv",
              "resolution": 480,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 127789,
            "audioChannels": 5.1,
            "audioCodec": "AAC",
            "audioLanguages": "und",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 874773,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "720x304",
            "runTime": "2:05:15",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": true,
          "id": 15
        },
        "popularity": 0.8,
        "lastSearchTime": "2024-09-24T23:15:26Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 944829422,
          "releaseGroups": []
        },
        "id": 22
      },
      {
        "title": "Nunakkuzhi",
        "originalTitle": "നുണക്കുഴി",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "nunakkuzhi",
        "sizeOnDisk": 1750879063,
        "status": "released",
        "overview": "Eby, an immature managing director desperately trying to retrieve his laptop from an income tax officer, finds himself caught in a web of deceit and his stupid decisions only lead him deeper into trouble.",
        "inCinemas": "2024-08-15T00:00:00Z",
        "digitalRelease": "2024-09-13T00:00:00Z",
        "releaseDate": "2024-09-13T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/23/poster.jpg?lastWrite=638634142091686397",
            "remoteUrl": "https://image.tmdb.org/t/p/original/xguc3XPxw0VJZzCa4wvmn7Od1Iq.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/23/fanart.jpg?lastWrite=638831307101664132",
            "remoteUrl": "https://image.tmdb.org/t/p/original/pps3IdtSlYx3wYgANTyFXYL75nH.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Vintage Films",
        "path": "/movies/Nunakkuzhi (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 16,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Nunakkuzhi (2024)",
        "runtime": 125,
        "cleanTitle": "nunakkuzhi",
        "imdbId": "tt29274198",
        "tmdbId": 1180620,
        "titleSlug": "1180620",
        "rootFolderPath": "/movies/",
        "genres": [
          "Comedy",
          "Family"
        ],
        "tags": [],
        "added": "2024-09-24T23:15:04Z",
        "ratings": {
          "imdb": {
            "votes": 3017,
            "value": 6.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 10,
            "value": 6.2,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 23,
          "relativePath": "Nunakkuzhi (2024).mkv",
          "path": "/movies/Nunakkuzhi (2024)/Nunakkuzhi (2024).mkv",
          "size": 1750879063,
          "dateAdded": "2024-09-24T23:15:04Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            },
            {
              "id": 45,
              "name": "Telugu"
            },
            {
              "id": 49,
              "name": "Kannada"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/tel/kan",
            "audioStreamCount": 3,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "h264",
            "videoFps": 25,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "2:01:03",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": false,
          "id": 16
        },
        "popularity": 0.5521,
        "lastSearchTime": "2024-09-24T23:15:30Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1750879063,
          "releaseGroups": []
        },
        "id": 23
      },
      {
        "title": "Raayan",
        "originalTitle": "ராயன்",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 39,
            "title": "Dhanush 50",
            "id": 164
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 39,
            "title": "D50",
            "id": 165
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 39,
            "title": "Rayan",
            "id": 166
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "raayan",
        "sizeOnDisk": 2840613479,
        "status": "released",
        "overview": "Raayan, a simpleton patriarch has to protect his family when they inadvertently get muddled in a violent world with whirlpool of murder, debauchery, feud, politics and power, a quagmire that he has repeatedly warned them not to get pulled into.",
        "inCinemas": "2024-07-26T00:00:00Z",
        "digitalRelease": "2024-08-23T00:00:00Z",
        "releaseDate": "2024-08-23T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/24/poster.jpg?lastWrite=638833899469492393",
            "remoteUrl": "https://image.tmdb.org/t/p/original/dHMbqpG7vZk1iEJaEkCCyixFbos.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/24/fanart.jpg?lastWrite=638833899471412517",
            "remoteUrl": "https://image.tmdb.org/t/p/original/1Us0a54s7aFDwDtIfRjlwvnLJQg.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Sun Pictures",
        "path": "/movies/Raayan (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 27,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Raayan (2024)",
        "runtime": 143,
        "cleanTitle": "raayan",
        "imdbId": "tt26233598",
        "tmdbId": 1136418,
        "titleSlug": "1136418",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Drama",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-09-24T23:15:11Z",
        "ratings": {
          "imdb": {
            "votes": 11065,
            "value": 6.5,
            "type": "user"
          },
          "tmdb": {
            "votes": 21,
            "value": 6.333,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 24,
          "relativePath": "Raayan(2024).mkv",
          "path": "/movies/Raayan (2024)/Raayan(2024).mkv",
          "size": 2840613479,
          "dateAdded": "2024-09-24T23:21:21Z",
          "edition": "",
          "languages": [
            {
              "id": 26,
              "name": "Hindi"
            },
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "hin/tam",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "h265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:23:44",
            "scanType": "Progressive",
            "subtitles": "eng/eng"
          },
          "qualityCutoffNotMet": false,
          "id": 27
        },
        "popularity": 2.3572,
        "lastSearchTime": "2024-09-24T23:15:46Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2840613479,
          "releaseGroups": []
        },
        "id": 24
      },
      {
        "title": "Ranam Aram Thavarel",
        "originalTitle": "ரணம் அறம் தவறேல்",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "ranam aram thavarel",
        "sizeOnDisk": 1624910838,
        "status": "released",
        "overview": "A series of unidentified and disfigured bodies are recovered by the police from across the city. A facial reconstruction artist is brought into the case to find those who are responsible for these killings. Will he be able to get to the bottom of the case and find the killer?",
        "inCinemas": "2024-02-23T00:00:00Z",
        "releaseDate": "2024-05-23T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/25/poster.jpg?lastWrite=638628165269387440",
            "remoteUrl": "https://image.tmdb.org/t/p/original/gwm57m06huc9pdawnbdeOVlWKN3.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/25/fanart.jpg?lastWrite=638811342203097066",
            "remoteUrl": "https://image.tmdb.org/t/p/original/7JHa1hn9hokRebTioEmziwzEq8O.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Mithun Mithra Productions (IN)",
        "path": "/movies/Ranam Aram Thavarel (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 17,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Ranam Aram Thavarel (2024)",
        "runtime": 121,
        "cleanTitle": "ranamaramthavarel",
        "imdbId": "tt27530559",
        "tmdbId": 1246021,
        "titleSlug": "1246021",
        "rootFolderPath": "/movies/",
        "genres": [
          "Mystery",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-09-24T23:15:18Z",
        "ratings": {
          "imdb": {
            "votes": 803,
            "value": 5.9,
            "type": "user"
          },
          "tmdb": {
            "votes": 1,
            "value": 8,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 25,
          "relativePath": "Ranam Aram Thavarel (2024).mkv",
          "path": "/movies/Ranam Aram Thavarel (2024)/Ranam Aram Thavarel (2024).mkv",
          "size": 1624910838,
          "dateAdded": "2024-09-24T23:15:26Z",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            },
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "tam/eng",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 29.970,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x818",
            "runTime": "2:00:05",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": false,
          "id": 17
        },
        "popularity": 0.4447,
        "lastSearchTime": "2024-09-24T23:16:00Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1624910838,
          "releaseGroups": []
        },
        "id": 25
      },
      {
        "title": "The Social Network",
        "originalTitle": "The Social Network",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 41,
            "title": "社交网站",
            "id": 167
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 41,
            "title": "Sosial Şebeke",
            "id": 168
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 41,
            "title": "Sotsialuri kseli",
            "id": 169
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 41,
            "title": "Shejiao wangluo",
            "id": 170
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 41,
            "title": "소셜 네트워크",
            "id": 171
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 41,
            "title": "La red social",
            "id": 172
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 41,
            "title": "Le réseau social",
            "id": 173
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 41,
            "title": "Սոցիալական ցանց",
            "id": 290
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "social network",
        "sizeOnDisk": 1289138071,
        "status": "released",
        "overview": "In 2003, Harvard undergrad and computer programmer Mark Zuckerberg begins work on a new concept that eventually turns into the global social network known as Facebook. Six years later, Mark is one of the youngest billionaires ever, but his unprecedented success leads to both personal and legal complications when he ends up on the receiving end of two lawsuits, one involving his former friend.",
        "inCinemas": "2010-10-01T00:00:00Z",
        "physicalRelease": "2010-11-25T00:00:00Z",
        "digitalRelease": "2013-08-15T00:00:00Z",
        "releaseDate": "2010-11-25T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/26/poster.jpg?lastWrite=638628165270867563",
            "remoteUrl": "https://image.tmdb.org/t/p/original/n0ybibhJtQ5icDqTp8eRytcIHJx.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/26/fanart.jpg?lastWrite=638813934866167052",
            "remoteUrl": "https://image.tmdb.org/t/p/original/cq9N64ucEtfIc3eMxNr1VzY9LH9.jpg"
          }
        ],
        "website": "https://www.sonypictures.com/movies/thesocialnetwork",
        "year": 2010,
        "youTubeTrailerId": "rBCNU0XT9GY",
        "studio": "Columbia Pictures",
        "path": "/movies/The Social Network (2010)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 18,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/The Social Network (2010)",
        "runtime": 121,
        "cleanTitle": "thesocialnetwork",
        "imdbId": "tt1285016",
        "tmdbId": 37799,
        "titleSlug": "37799",
        "rootFolderPath": "/movies/",
        "certification": "PG-13",
        "genres": [
          "Drama"
        ],
        "tags": [],
        "added": "2024-09-24T23:15:26Z",
        "ratings": {
          "imdb": {
            "votes": 791654,
            "value": 7.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 12444,
            "value": 7.4,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 95,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 96,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 26,
          "relativePath": "The Social Network (2010).mp4",
          "path": "/movies/The Social Network (2010)/The Social Network (2010).mp4",
          "size": 1289138071,
          "dateAdded": "2024-09-24T23:15:26Z",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 9,
              "name": "HDTV-1080p",
              "source": "tv",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 96000,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 1327088,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:00:27",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "qualityCutoffNotMet": false,
          "id": 18
        },
        "popularity": 36.7296,
        "lastSearchTime": "2024-09-24T23:15:53Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1289138071,
          "releaseGroups": []
        },
        "id": 26
      },
      {
        "title": "Thalavan",
        "originalTitle": "തലവൻ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "thalavan",
        "sizeOnDisk": 2528898530,
        "status": "released",
        "overview": "The intense rivalry between two police officers—CI Jayashankar and SI Karthik takes a dark turn when a body is found in Jayashankar’s house, and he becomes the prime suspect in a murder investigation, which is led by Karthik, adding a layer of tension to their already strained relationship.",
        "inCinemas": "2024-05-24T00:00:00Z",
        "releaseDate": "2024-08-22T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/27/poster.jpg?lastWrite=638813070645743747",
            "remoteUrl": "https://image.tmdb.org/t/p/original/142iirjj2365WQTaXgMrmjC0tng.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/27/fanart.jpg?lastWrite=638628165466123800",
            "remoteUrl": "https://image.tmdb.org/t/p/original/myjVHnn5f1p393JQD2h6gcvmM34.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "jhUyy5DdUZI",
        "studio": "Arun Narayan Productions",
        "path": "/movies/Thalavan (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 19,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Thalavan (2024)",
        "runtime": 133,
        "cleanTitle": "thalavan",
        "imdbId": "tt27510257",
        "tmdbId": 1112108,
        "titleSlug": "1112108",
        "rootFolderPath": "/movies/",
        "genres": [
          "Thriller",
          "Drama",
          "Crime"
        ],
        "tags": [],
        "added": "2024-09-24T23:15:43Z",
        "ratings": {
          "imdb": {
            "votes": 4816,
            "value": 7.2,
            "type": "user"
          },
          "tmdb": {
            "votes": 14,
            "value": 6.786,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 27,
          "relativePath": "Thalavan (2024).mkv",
          "path": "/movies/Thalavan (2024)/Thalavan (2024).mkv",
          "size": 2528898530,
          "dateAdded": "2024-09-24T23:15:46Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 256000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x720",
            "runTime": "2:10:51",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": false,
          "id": 19
        },
        "popularity": 0.8777,
        "lastSearchTime": "2024-09-24T23:16:08Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2528898530,
          "releaseGroups": []
        },
        "id": 27
      },
      {
        "title": "Varshangalkku Shesham",
        "originalTitle": "വർഷങ്ങൾക്ക് ശേഷം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 43,
            "title": "VS",
            "id": 174
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "varshangalkku shesham",
        "sizeOnDisk": 2113884717,
        "status": "released",
        "overview": "Set in the 1970s and '80s, a man of many talents and an aspiring filmmaker come together in their shared ambition of making it big in the magical world of cinema. As they struggle with a burning desire to prove themselves, can their friendship survive the test of time?",
        "inCinemas": "2024-04-11T00:00:00Z",
        "releaseDate": "2024-07-10T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/28/poster.jpg?lastWrite=638804428324213719",
            "remoteUrl": "https://image.tmdb.org/t/p/original/dVLqE9aEszo8yrc8TDk3bloYHHS.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/28/fanart.jpg?lastWrite=638804428326493886",
            "remoteUrl": "https://image.tmdb.org/t/p/original/d2LcfSjPO0L8esuRXqhQU10JzpQ.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "50GJ7D_00NA",
        "studio": "Merryland Studios",
        "path": "/movies/Varshangalkku Shesham (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 20,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Varshangalkku Shesham (2024)",
        "runtime": 165,
        "cleanTitle": "varshangalkkushesham",
        "imdbId": "tt28364355",
        "tmdbId": 1151560,
        "titleSlug": "1151560",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama",
          "Comedy",
          "Romance"
        ],
        "tags": [],
        "added": "2024-09-24T23:16:46Z",
        "ratings": {
          "imdb": {
            "votes": 4184,
            "value": 6.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 10,
            "value": 6,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 28,
          "relativePath": "Varshangalkku Shesham (2024).mkv",
          "path": "/movies/Varshangalkku Shesham (2024)/Varshangalkku Shesham (2024).mkv",
          "size": 2113884717,
          "dateAdded": "2024-09-24T23:16:46Z",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:44:03",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "qualityCutoffNotMet": false,
          "id": 20
        },
        "popularity": 0.5208,
        "lastSearchTime": "2024-09-24T23:16:57Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2113884717,
          "releaseGroups": []
        },
        "id": 28
      },
      {
        "title": "The Greatest Showman",
        "originalTitle": "The Greatest Showman",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 44,
            "title": "Muhteşem Şovmen",
            "id": 175
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 44,
            "title": "위대한 쇼맨",
            "id": 176
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 44,
            "title": "马戏之王",
            "id": 256
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "greatest showman",
        "sizeOnDisk": 1695858514,
        "status": "released",
        "overview": "The story of American showman P.T. Barnum, founder of the circus that became the famous traveling Ringling Bros. and Barnum & Bailey Circus.",
        "inCinemas": "2017-12-20T00:00:00Z",
        "physicalRelease": "2018-04-10T00:00:00Z",
        "digitalRelease": "2018-03-20T00:00:00Z",
        "releaseDate": "2018-03-20T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/29/poster.jpg?lastWrite=638704137789360987",
            "remoteUrl": "https://image.tmdb.org/t/p/original/b9CeobiihCx1uG1tpw8hXmpi7nm.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/29/fanart.jpg?lastWrite=638794059047913610",
            "remoteUrl": "https://image.tmdb.org/t/p/original/lrNKm3HNvGdZoAfiBKu7b04FLHN.jpg"
          }
        ],
        "website": "http://thegreatestshowman.com/",
        "year": 2017,
        "youTubeTrailerId": "KTNtpYQPlhE",
        "studio": "Chernin Entertainment",
        "path": "/movies/The Greatest Showman (2017)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 30,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/The Greatest Showman (2017)",
        "runtime": 105,
        "cleanTitle": "thegreatestshowman",
        "imdbId": "tt1485796",
        "tmdbId": 316029,
        "titleSlug": "316029",
        "rootFolderPath": "/movies/",
        "certification": "PG",
        "genres": [
          "Drama"
        ],
        "tags": [],
        "added": "2024-09-25T13:54:40Z",
        "ratings": {
          "imdb": {
            "votes": 331025,
            "value": 7.5,
            "type": "user"
          },
          "tmdb": {
            "votes": 9628,
            "value": 7.9,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 48,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 56,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 29,
          "relativePath": "The Greatest Showman (2017).mp4",
          "path": "/movies/The Greatest Showman (2017)/The Greatest Showman (2017).mp4",
          "size": 1695858514,
          "dateAdded": "2024-09-25T14:09:41Z",
          "sceneName": "The Greatest Showman (2017) [1080p] [YTS.ME]",
          "releaseGroup": "YTS",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 7,
              "name": "Bluray-1080p",
              "source": "bluray",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 128000,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "und",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 2022175,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "1:44:49",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "The Greatest Showman (2017) [1080p] [YTS.ME]/The.Greatest.Showman.2017.1080p.BluRay.x264-[YTS.ME].mp4",
          "qualityCutoffNotMet": false,
          "id": 30
        },
        "popularity": 9.1323,
        "lastSearchTime": "2024-09-25T14:00:41Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1695858514,
          "releaseGroups": [
            "YTS"
          ]
        },
        "id": 29
      },
      {
        "title": "Harry Potter and the Goblet of Fire",
        "originalTitle": "Harry Potter and the Goblet of Fire",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "Harry Potter dhe Kupa e Zjarrit",
            "id": 177
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "ハリー・ポッターと炎のゴブレット",
            "id": 178
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "Harijs Poters un Uguns biķeris",
            "id": 179
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "הרי פותר וגביע האש",
            "id": 180
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "Harry Potter ja tulepeeker",
            "id": 181
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "แฮร์รี่ พอตเตอร์กับถ้วยอัคนี",
            "id": 183
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "해리포터와 불의 잔",
            "id": 184
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "هاري بوتر وكأس النار",
            "id": 185
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "Harry Potter (4) et la Coupe de feu",
            "id": 186
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "Harry Potter IV: Harry Potter and the Goblet of Fire",
            "id": 187
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "Harry Potter und der Feuerkelch",
            "id": 222
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "Հարրի Փոթերը և Կրակի գավաթը",
            "id": 289
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "해리 포터 4",
            "id": 292
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 45,
            "title": "哈利·波特与火焰杯",
            "id": 296
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "harry potter goblet fire",
        "sizeOnDisk": 2260089520,
        "status": "released",
        "overview": "When Harry Potter's name emerges from the Goblet of Fire, he becomes a competitor in a grueling battle for glory among three wizarding schools—the Triwizard Tournament. But since Harry never submitted his name for the Tournament, who did? Now Harry must confront a deadly dragon, fierce water demons and an enchanted maze only to find himself in the cruel grasp of He Who Must Not Be Named.",
        "inCinemas": "2005-11-16T00:00:00Z",
        "physicalRelease": "2006-03-29T00:00:00Z",
        "digitalRelease": "2008-12-26T00:00:00Z",
        "releaseDate": "2006-03-29T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/30/poster.jpg?lastWrite=638628810560748707",
            "remoteUrl": "https://image.tmdb.org/t/p/original/fECBtHlr0RB3foNHDiCBXeg9Bv9.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/30/fanart.jpg?lastWrite=638810477795221177",
            "remoteUrl": "https://image.tmdb.org/t/p/original/5rrGVmRUuCKVbqUu41XIWTXJmNA.jpg"
          }
        ],
        "website": "https://www.warnerbros.com/movies/harry-potter-and-goblet-fire/",
        "year": 2005,
        "youTubeTrailerId": "4xkFJgcCQRE",
        "studio": "Warner Bros. Pictures",
        "path": "/movies/Harry Potter and the Goblet of Fire (2005)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 31,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Harry Potter and the Goblet of Fire (2005)",
        "runtime": 157,
        "cleanTitle": "harrypottergobletfire",
        "imdbId": "tt0330373",
        "tmdbId": 674,
        "titleSlug": "674",
        "rootFolderPath": "/movies/",
        "certification": "PG-13",
        "genres": [
          "Adventure",
          "Fantasy"
        ],
        "tags": [],
        "added": "2024-09-25T17:10:53Z",
        "ratings": {
          "imdb": {
            "votes": 719114,
            "value": 7.7,
            "type": "user"
          },
          "tmdb": {
            "votes": 21203,
            "value": 7.8,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 81,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 88,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 30,
          "relativePath": "Harry Potter and the Goblet of Fire (2005).mp4",
          "path": "/movies/Harry Potter and the Goblet of Fire (2005)/Harry Potter and the Goblet of Fire (2005).mp4",
          "size": 2260089520,
          "dateAdded": "2024-09-25T17:21:45Z",
          "sceneName": "Harry Potter and the Goblet of Fire (2005) [1080p]",
          "releaseGroup": "1080p",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 7,
              "name": "Bluray-1080p",
              "source": "bluray",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 92000,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "und",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 1822527,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x798",
            "runTime": "2:37:05",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "Harry Potter and the Goblet of Fire (2005) [1080p]/Harry.Potter.and.the.Goblet.of.Fire.2005.1080p.BrRip.x264.YIFY.mp4",
          "qualityCutoffNotMet": false,
          "id": 31
        },
        "collection": {
          "title": "Harry Potter Collection",
          "tmdbId": 1241
        },
        "popularity": 25.0691,
        "lastSearchTime": "2024-09-25T17:11:17Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2260089520,
          "releaseGroups": [
            "1080p"
          ]
        },
        "id": 30
      },
      {
        "title": "Bharathanatyam",
        "originalTitle": "ഭരതനാട്യം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 53,
            "title": "Bharatanatyam",
            "id": 189
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 53,
            "title": "Bharadhanatyam",
            "id": 190
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 53,
            "title": "اشتباه باراتان",
            "id": 291
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "bharathanatyam",
        "sizeOnDisk": 2829947355,
        "status": "released",
        "overview": "A man makes a startling discovery following his father's sudden hospitalization and attempts to prevent his family's secret from reaching the local townsfolk.",
        "inCinemas": "2024-08-30T00:00:00Z",
        "releaseDate": "2024-11-28T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/31/poster.jpg?lastWrite=638635006107350949",
            "remoteUrl": "https://image.tmdb.org/t/p/original/roEHh97z7KaigdoWWk3S6SJc0UK.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/31/fanart.jpg?lastWrite=638811342064326346",
            "remoteUrl": "https://image.tmdb.org/t/p/original/2nKAQpPZsjhYwT1qOYarpggOVXx.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Thomas Thiruvalla Films",
        "path": "/movies/Bharathanatyam (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 32,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Bharathanatyam (2024)",
        "runtime": 121,
        "cleanTitle": "bharathanatyam",
        "imdbId": "tt31639439",
        "tmdbId": 1321820,
        "titleSlug": "1321820",
        "rootFolderPath": "/movies/",
        "genres": [
          "Comedy",
          "Drama"
        ],
        "tags": [],
        "added": "2024-09-26T23:29:04Z",
        "ratings": {
          "imdb": {
            "votes": 1635,
            "value": 6.7,
            "type": "user"
          },
          "tmdb": {
            "votes": 2,
            "value": 8.5,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 31,
          "relativePath": "Bharathanatyam (2024).mkv",
          "path": "/movies/Bharathanatyam (2024)/Bharathanatyam (2024).mkv",
          "size": 2829947355,
          "dateAdded": "2024-09-26T23:44:56Z",
          "sceneName": "www.1TamilBlasters.dad - Bharathanatyam (2024) Malayalam 1080p HDRip DDP5.1 + AAC x264 2.6GB ESubs",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 640000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:00:58",
            "scanType": "Progressive",
            "subtitles": "eng/eng"
          },
          "originalFilePath": "www.1TamilBlasters.dad - Bharathanatyam (2024) Malayalam 1080p HDRip DDP5.1 + AAC x264 2.6GB ESubs.mkv",
          "qualityCutoffNotMet": false,
          "id": 32
        },
        "popularity": 0.4583,
        "lastSearchTime": "2024-09-26T23:29:26Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2829947355,
          "releaseGroups": []
        },
        "id": 31
      },
      {
        "title": "Irul",
        "originalTitle": "ഇരുൾ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 54,
            "title": "Aparadhi",
            "id": 342
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "irul",
        "sizeOnDisk": 0,
        "status": "released",
        "overview": "A dark rainy night, an empty house, a stranded couple and an unknown man. A sleek game of the cat and the mouse starts playing on, as the three of them find a dead body in the basement.",
        "digitalRelease": "2021-04-02T00:00:00Z",
        "releaseDate": "2021-04-02T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/32/poster.jpg?lastWrite=638840812133575597",
            "remoteUrl": "https://image.tmdb.org/t/p/original/cePtRJSY9UCOrgBI2K6SeThOxz5.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/32/fanart.jpg?lastWrite=638748212453088448",
            "remoteUrl": "https://image.tmdb.org/t/p/original/3FHaE8ngmEJVsd0jWiT8P0LrEhR.jpg"
          }
        ],
        "website": "",
        "year": 2021,
        "youTubeTrailerId": "",
        "studio": "Anto Joseph Film Company",
        "path": "/movies/Irul (2021)",
        "qualityProfileId": 1,
        "hasFile": false,
        "movieFileId": 0,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Irul (2021)",
        "runtime": 91,
        "cleanTitle": "irul",
        "imdbId": "tt13103212",
        "tmdbId": 807158,
        "titleSlug": "807158",
        "rootFolderPath": "/movies/",
        "genres": [
          "Thriller",
          "Mystery"
        ],
        "tags": [],
        "added": "2024-09-29T00:39:16Z",
        "ratings": {
          "imdb": {
            "votes": 3835,
            "value": 5.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 30,
            "value": 5.6,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 0,
            "type": "user"
          }
        },
        "popularity": 1.4834,
        "lastSearchTime": "2024-09-29T00:39:43Z",
        "statistics": {
          "movieFileCount": 0,
          "sizeOnDisk": 0,
          "releaseGroups": []
        },
        "id": 32
      },
      {
        "title": "Furiosa: A Mad Max Saga",
        "originalTitle": "Furiosa: A Mad Max Saga",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "Mad Max: Furiosa",
            "id": 191
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "Furiosa",
            "id": 192
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "Furioza: Pobesneli Maks saga",
            "id": 193
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "Furiosa: Une Saga Mad Max",
            "id": 194
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "Furiosa: de la saga Mad Max",
            "id": 195
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "فيريوسا",
            "id": 196
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "فيريوسا: ملحمة ماد ماكس",
            "id": 197
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "פיוריוסה: סאגת מקס הזועם",
            "id": 198
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "Mad Max 5",
            "id": 199
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "疯狂的麦克斯6",
            "id": 200
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "Mad Max 5 Furiosa",
            "id": 201
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 55,
            "title": "芙莉歐莎：瘋狂麥斯傳奇篇章",
            "id": 276
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "furiosa mad max saga",
        "sizeOnDisk": 1722812359,
        "status": "released",
        "overview": "As the world falls, young Furiosa is snatched from the Green Place of Many Mothers into the hands of a great biker horde led by the warlord Dementus. Sweeping through the wasteland, they encounter the citadel presided over by Immortan Joe. The two tyrants wage war for dominance, and Furiosa must survive many trials as she puts together the means to find her way home.",
        "inCinemas": "2024-05-22T00:00:00Z",
        "physicalRelease": "2024-08-12T00:00:00Z",
        "digitalRelease": "2024-06-24T00:00:00Z",
        "releaseDate": "2024-06-24T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/33/poster.jpg?lastWrite=638715374477437607",
            "remoteUrl": "https://image.tmdb.org/t/p/original/iADOJ8Zymht2JPMoy3R7xceZprc.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/33/fanart.jpg?lastWrite=638634841311937771",
            "remoteUrl": "https://image.tmdb.org/t/p/original/wNAhuOZ3Zf84jCIlrcI6JhgmY5q.jpg"
          }
        ],
        "website": "https://www.furiosaamadmaxsaga.com",
        "year": 2024,
        "youTubeTrailerId": "LYV3001u574",
        "studio": "Warner Bros. Pictures",
        "path": "/movies/Furiosa A Mad Max Saga (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 33,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Furiosa A Mad Max Saga (2024)",
        "runtime": 149,
        "cleanTitle": "furiosamadmaxsaga",
        "imdbId": "tt12037194",
        "tmdbId": 786892,
        "titleSlug": "786892",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Action",
          "Science Fiction",
          "Adventure"
        ],
        "tags": [],
        "added": "2024-10-02T16:42:08Z",
        "ratings": {
          "imdb": {
            "votes": 289482,
            "value": 7.5,
            "type": "user"
          },
          "tmdb": {
            "votes": 4193,
            "value": 7.478,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 79,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 90,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 33,
          "relativePath": "Furiosa A Mad Max Saga (2024).mkv",
          "path": "/movies/Furiosa A Mad Max Saga (2024)/Furiosa A Mad Max Saga (2024).mkv",
          "size": 1722812359,
          "dateAdded": "2024-10-02T16:51:14Z",
          "sceneName": "Furiosa.A.Mad.Max.Saga.2024.1080p.WEBRip.1600MB.DD5.1.x264-GalaxyRG[TGx]",
          "releaseGroup": "GalaxyRG",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 320000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:28:11",
            "scanType": "Progressive",
            "subtitles": "eng/eng/ger/spa/kor/nor"
          },
          "originalFilePath": "Furiosa.A.Mad.Max.Saga.2024.1080p.WEBRip.1600MB.DD5.1.x264-GalaxyRG[TGx]/Furiosa.A.Mad.Max.Saga.2024.1080p.WEBRip.1600MB.DD5.1.x264-GalaxyRG.mkv",
          "qualityCutoffNotMet": false,
          "id": 33
        },
        "collection": {
          "title": "Mad Max Collection",
          "tmdbId": 8945
        },
        "popularity": 19.0816,
        "lastSearchTime": "2024-10-02T16:42:33Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1722812359,
          "releaseGroups": [
            "GalaxyRG"
          ]
        },
        "id": 33
      },
      {
        "title": "The Goat Life",
        "originalTitle": "ആടുജീവിതം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 61,
            "title": "Aadu Jeevitham",
            "id": 202
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 61,
            "title": "Goat Days",
            "id": 203
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 61,
            "title": "山羊生活",
            "id": 204
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 61,
            "title": "放牧他乡",
            "id": 205
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 61,
            "title": "Козья жизнь",
            "id": 206
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "goat life",
        "sizeOnDisk": 3380457399,
        "status": "released",
        "overview": "Indian migrant worker Najeeb Muhammad goes to Saudi Arabia to earn money. However, in a twist of fate, he finds himself living a slave-like existence, herding goats in the middle of the desert.",
        "inCinemas": "2024-03-28T00:00:00Z",
        "digitalRelease": "2024-07-19T00:00:00Z",
        "releaseDate": "2024-07-19T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/34/poster.jpg?lastWrite=638723152349861318",
            "remoteUrl": "https://image.tmdb.org/t/p/original/l7z3Skv1xLASnUt0whC4IInaXt0.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/34/fanart.jpg?lastWrite=638736114648120357",
            "remoteUrl": "https://image.tmdb.org/t/p/original/u7GXKY7EUTBS4kQO6aXqDNXWgpd.jpg"
          }
        ],
        "website": "https://thegoatlifefilm.com/",
        "year": 2024,
        "youTubeTrailerId": "qvsiJKdDxPs",
        "studio": "Visual Romance",
        "path": "/movies/The Goat Life (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 40,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/The Goat Life (2024)",
        "runtime": 172,
        "cleanTitle": "thegoatlife",
        "imdbId": "tt5525650",
        "tmdbId": 472221,
        "titleSlug": "472221",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama"
        ],
        "tags": [],
        "added": "2024-10-08T19:10:19Z",
        "ratings": {
          "imdb": {
            "votes": 47579,
            "value": 7.1,
            "type": "user"
          },
          "tmdb": {
            "votes": 40,
            "value": 7.2,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 78,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 34,
          "relativePath": "The Goat Life (2024).mp4",
          "path": "/movies/The Goat Life (2024)/The Goat Life (2024).mp4",
          "size": 3380457399,
          "dateAdded": "2024-11-24T14:18:29Z",
          "sceneName": "The Goat Life (2024) [1080p] [WEBRip] [5.1] [YTS.MX]",
          "releaseGroup": "YTS.MX",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 384000,
            "audioChannels": 5.1,
            "audioCodec": "AAC",
            "audioLanguages": "und",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 2249881,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x812",
            "runTime": "2:50:46",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "The Goat Life (2024) [1080p] [WEBRip] [5.1] [YTS.MX]/The.Goat.Life.2024.1080p.WEBRip.x264.AAC5.1-[YTS.MX].mp4",
          "qualityCutoffNotMet": false,
          "id": 40
        },
        "popularity": 3.3295,
        "lastSearchTime": "2024-11-24T14:07:51Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 3380457399,
          "releaseGroups": [
            "YTS.MX"
          ]
        },
        "id": 34
      },
      {
        "title": "Garuda Gamana Vrishabha Vahana",
        "originalTitle": "ಗರುಡ ಗಮನ ವೃಷಭ ವಾಹನ",
        "originalLanguage": {
          "id": 49,
          "name": "Kannada"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 62,
            "title": "GGVV",
            "id": 209
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "garuda gamana vrishabha vahana",
        "sizeOnDisk": 1293601197,
        "status": "released",
        "overview": "Shiva and Hari, two friends who are polar opposites in demeanour, are the terror in Mangaladevi. What happens when ego, ambition and jealousy creeps in between their strong friendship?",
        "inCinemas": "2021-11-19T00:00:00Z",
        "releaseDate": "2022-02-17T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/35/poster.jpg?lastWrite=638826122063934685",
            "remoteUrl": "https://image.tmdb.org/t/p/original/5jWfzHXvqLllbsVL7bvV1UVTq8s.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/35/fanart.jpg?lastWrite=638800107868406687",
            "remoteUrl": "https://image.tmdb.org/t/p/original/kNghJfQyWCXYIot7y5HTmQCml7v.jpg"
          }
        ],
        "website": "",
        "year": 2021,
        "youTubeTrailerId": "",
        "studio": "Paramvah Studios",
        "path": "/movies/Garuda Gamana Vrishabha Vahana (2021)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 34,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Garuda Gamana Vrishabha Vahana (2021)",
        "runtime": 151,
        "cleanTitle": "garudagamanavrishabhavahana",
        "imdbId": "tt11953248",
        "tmdbId": 678466,
        "titleSlug": "678466",
        "rootFolderPath": "/movies/",
        "genres": [
          "Crime",
          "Drama",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-10-09T22:07:01Z",
        "ratings": {
          "imdb": {
            "votes": 8729,
            "value": 8.2,
            "type": "user"
          },
          "tmdb": {
            "votes": 13,
            "value": 7.5,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 35,
          "relativePath": "Garuda Gamana Vrishabha Vahana (2021).mkv",
          "path": "/movies/Garuda Gamana Vrishabha Vahana (2021)/Garuda Gamana Vrishabha Vahana (2021).mkv",
          "size": 1293601197,
          "dateAdded": "2024-10-10T02:11:00Z",
          "sceneName": "www.TamilBlasters.sbs - Garuda Gamana Vrishabha Vahana (2021) [Kannada - 1080p HDRip - HEVC - x265 - AAC - 1.3GB - ESubs]",
          "edition": "",
          "languages": [
            {
              "id": 49,
              "name": "Kannada"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "kan",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 25,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:30:21",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.TamilBlasters.sbs - Garuda Gamana Vrishabha Vahana (2021) [Kannada - 1080p HDRip - HEVC - x265 - AAC - 1.3GB - ESubs].mkv",
          "qualityCutoffNotMet": false,
          "id": 34
        },
        "popularity": 0.3715,
        "lastSearchTime": "2024-10-09T22:07:24Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1293601197,
          "releaseGroups": []
        },
        "id": 35
      },
      {
        "title": "Rebel Ridge",
        "originalTitle": "Rebel Ridge",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 63,
            "title": "叛军岭",
            "id": 223
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 63,
            "title": "مرز طغیانگری",
            "id": 224
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 63,
            "title": "逆岭",
            "id": 225
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "rebel ridge",
        "sizeOnDisk": 1726865994,
        "status": "released",
        "overview": "A former Marine confronts corruption in a small town when local law enforcement unjustly seizes the bag of cash he needs to post his cousin's bail.",
        "digitalRelease": "2024-09-05T00:00:00Z",
        "releaseDate": "2024-09-05T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/36/poster.jpg?lastWrite=638797515614907347",
            "remoteUrl": "https://image.tmdb.org/t/p/original/xEt2GSz9z5rSVpIHMiGdtf0czyf.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/36/fanart.jpg?lastWrite=638839084050374980",
            "remoteUrl": "https://image.tmdb.org/t/p/original/cyKH7pDFlxIXluqRyNoHHEpxSDX.jpg"
          }
        ],
        "website": "https://www.netflix.com/title/81157729",
        "year": 2024,
        "youTubeTrailerId": "gF3gZicntIw",
        "studio": "filmscience",
        "path": "/movies/Rebel Ridge (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 35,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Rebel Ridge (2024)",
        "runtime": 132,
        "cleanTitle": "rebelridge",
        "imdbId": "tt11301886",
        "tmdbId": 646097,
        "titleSlug": "646097",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Crime",
          "Action",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-10-26T02:19:02Z",
        "ratings": {
          "imdb": {
            "votes": 90169,
            "value": 6.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 1326,
            "value": 7.001,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 76,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 95,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 36,
          "relativePath": "Rebel Ridge (2024).mkv",
          "path": "/movies/Rebel Ridge (2024)/Rebel Ridge (2024).mkv",
          "size": 1726865994,
          "dateAdded": "2024-10-26T02:28:29Z",
          "sceneName": "Rebel.Ridge.2024.1080p.NF.WEBRip.1600MB.DD5.1.x264-GalaxyRG[TGx]",
          "releaseGroup": "GalaxyRG",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 320000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:11:39",
            "scanType": "Progressive",
            "subtitles": "eng/eng/ara/cze/dan/ger/gre/spa/spa/fin/fil/fre/heb/hrv/hun/ind/ita/jpn/kor/may/nob/dut/pol/por/por/rum/rus/swe/tha/tur/ukr/vie/chi/chi"
          },
          "originalFilePath": "Rebel.Ridge.2024.1080p.NF.WEBRip.1600MB.DD5.1.x264-GalaxyRG[TGx]/Rebel.Ridge.2024.1080p.NF.WEBRip.1600MB.DD5.1.x264-GalaxyRG.mkv",
          "qualityCutoffNotMet": false,
          "id": 35
        },
        "popularity": 7.484,
        "lastSearchTime": "2024-10-26T02:20:03Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1726865994,
          "releaseGroups": [
            "GalaxyRG"
          ]
        },
        "id": 36
      },
      {
        "title": "Meiyazhagan",
        "originalTitle": "மெய்யழகன்",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 64,
            "title": "Karthi 27",
            "id": 226
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 64,
            "title": "Sathyam Sundaram",
            "id": 227
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "meiyazhagan",
        "sizeOnDisk": 2737962623,
        "status": "released",
        "overview": "Twenty-two years after losing his home, Arulmozhi Varman returns to his native Thanjavur to attend his cousin's wedding. Amidst the celebrations, Arul is reintroduced to an upbeat man whom he cannot recall. With the help of the unknown man, Arul reconnects with his past.",
        "inCinemas": "2024-09-27T00:00:00Z",
        "releaseDate": "2024-12-26T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/37/poster.jpg?lastWrite=638743027659735769",
            "remoteUrl": "https://image.tmdb.org/t/p/original/ngDEH7YqVaMCAD4LpNxRl6ScJnw.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/37/fanart.jpg?lastWrite=638656474569122669",
            "remoteUrl": "https://image.tmdb.org/t/p/original/9v5Q5OOR9e83KBlK6SPQEcbm6Iw.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "2D Entertainment",
        "path": "/movies/Meiyazhagan (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 36,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Meiyazhagan (2024)",
        "runtime": 177,
        "cleanTitle": "meiyazhagan",
        "imdbId": "tt26758372",
        "tmdbId": 1136423,
        "titleSlug": "1136423",
        "rootFolderPath": "/movies/",
        "genres": [
          "Family",
          "Drama"
        ],
        "tags": [],
        "added": "2024-10-27T17:37:36Z",
        "ratings": {
          "imdb": {
            "votes": 14889,
            "value": 8.4,
            "type": "user"
          },
          "tmdb": {
            "votes": 29,
            "value": 7.621,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 37,
          "relativePath": "Meiyazhagan (2024).mkv",
          "path": "/movies/Meiyazhagan (2024)/Meiyazhagan (2024).mkv",
          "size": 2737962623,
          "dateAdded": "2024-10-27T17:52:24Z",
          "sceneName": "Meiyazhagan (2024) 1080p WEBRip x265 AAC [ Hin, Tam ] ESub",
          "edition": "",
          "languages": [
            {
              "id": 26,
              "name": "Hindi"
            },
            {
              "id": 45,
              "name": "Telugu"
            },
            {
              "id": 43,
              "name": "Tamil"
            },
            {
              "id": 48,
              "name": "Malayalam"
            },
            {
              "id": 49,
              "name": "Kannada"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 5.1,
            "audioCodec": "AAC",
            "audioLanguages": "hin/tel/tam/mal/kan",
            "audioStreamCount": 5,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:38:15",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "Meiyazhagan (2024) 1080p WEBRip x265 AAC [ Hin, Tam ] ESub.mkv",
          "qualityCutoffNotMet": false,
          "id": 36
        },
        "popularity": 4.0913,
        "lastSearchTime": "2024-10-27T17:38:01Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2737962623,
          "releaseGroups": []
        },
        "id": 37
      },
      {
        "title": "A.R.M",
        "originalTitle": "അജയന്റെ രണ്ടാം മോഷണം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 65,
            "title": "Ajayante Randam Moshanam",
            "id": 229
          }
        ],
        "secondaryYear": 2025,
        "secondaryYearSourceId": 0,
        "sortTitle": "r m",
        "sizeOnDisk": 1810406855,
        "status": "released",
        "overview": "Set in the Northern Kerala in 1900, 1950 and 1990, Three generations of heroes Maniyan, Kunjikelu and Ajayan, try to protect the most important treasure of the Land.",
        "inCinemas": "2024-09-12T00:00:00Z",
        "digitalRelease": "2024-11-08T00:00:00Z",
        "releaseDate": "2024-11-08T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/38/poster.jpg?lastWrite=638666212051066370",
            "remoteUrl": "https://image.tmdb.org/t/p/original/OClpEeRlHK3DrFO7QtWXtpDIOK.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/38/fanart.jpg?lastWrite=638667843352784449",
            "remoteUrl": "https://image.tmdb.org/t/p/original/4VMaNlyZg7HNCTwkAIdi39j8463.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "United Global Media Entertainments",
        "path": "/movies/A.R.M (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 37,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/A.R.M (2024)",
        "runtime": 147,
        "cleanTitle": "arm",
        "imdbId": "tt11531182",
        "tmdbId": 890138,
        "titleSlug": "890138",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Adventure",
          "Drama"
        ],
        "tags": [],
        "added": "2024-11-08T00:06:44Z",
        "ratings": {
          "imdb": {
            "votes": 8683,
            "value": 7.1,
            "type": "user"
          },
          "tmdb": {
            "votes": 11,
            "value": 7,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 38,
          "relativePath": "A.R.M (2024).mkv",
          "path": "/movies/A.R.M (2024)/A.R.M (2024).mkv",
          "size": 1810406855,
          "dateAdded": "2024-11-08T00:21:49Z",
          "sceneName": "www.1TamilBlasters.foo - A.R.M (2024)[Malayalam - 1080p HQ HDRip HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.7GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:27:01",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.foo - A.R.M (2024)[Malayalam - 1080p HQ HDRip HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.7GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 37
        },
        "popularity": 1.4538,
        "lastSearchTime": "2025-04-01T15:10:55Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1810406855,
          "releaseGroups": []
        },
        "id": 38
      },
      {
        "title": "Kishkindha Kaandam",
        "originalTitle": "കിഷ്കിന്ധാ കാണ്ഡം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 66,
            "title": "قلمروی میمون ها",
            "id": 267
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "kishkindha kaandam",
        "sizeOnDisk": 2580673189,
        "status": "released",
        "overview": "Strange events unfold in a monkey-inhabited village, driving a newlywed couple and forest officials to embark on a mission to uncover the root of the unusual disturbances.",
        "inCinemas": "2024-09-12T00:00:00Z",
        "digitalRelease": "2024-11-19T00:00:00Z",
        "releaseDate": "2024-11-19T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/39/poster.jpg?lastWrite=638676357106873384",
            "remoteUrl": "https://image.tmdb.org/t/p/original/rniBYHDRs6e8qMkPr4D4ZE5uMhF.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/39/fanart.jpg?lastWrite=638819208298180938",
            "remoteUrl": "https://image.tmdb.org/t/p/original/sqv6AUWkVLS7s9rWxhiChIiSQdd.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "6jR7lL-o7js",
        "studio": "Goodwill Entertainments",
        "path": "/movies/Kishkindha Kaandam (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 38,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Kishkindha Kaandam (2024)",
        "runtime": 125,
        "cleanTitle": "kishkindhakaandam",
        "imdbId": "tt15980138",
        "tmdbId": 1025125,
        "titleSlug": "1025125",
        "rootFolderPath": "/movies/",
        "genres": [
          "Thriller",
          "Mystery",
          "Drama"
        ],
        "tags": [],
        "added": "2024-11-19T17:55:10Z",
        "ratings": {
          "imdb": {
            "votes": 12200,
            "value": 8,
            "type": "user"
          },
          "tmdb": {
            "votes": 35,
            "value": 7.4,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 39,
          "relativePath": "Kishkindha Kaandam (2024).mkv",
          "path": "/movies/Kishkindha Kaandam (2024)/Kishkindha Kaandam (2024).mkv",
          "size": 2580673189,
          "dateAdded": "2024-11-19T18:07:35Z",
          "sceneName": "www.1TamilBlasters.fyi - Kishkindha Kaandam (2024) [Malayalam - 1080p HQ HDRip - x264 - [DDP 5.1 (192Kbps) + AAC] - 2.4GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:03:39",
            "scanType": "Progressive",
            "subtitles": "eng/eng"
          },
          "originalFilePath": "www.1TamilBlasters.fyi - Kishkindha Kaandam (2024) [Malayalam - 1080p HQ HDRip - x264 - [DDP 5.1 (192Kbps) + AAC] - 2.4GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 38
        },
        "popularity": 1.3607,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2580673189,
          "releaseGroups": []
        },
        "id": 39
      },
      {
        "title": "The Batman",
        "originalTitle": "The Batman",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "Бэтмен",
            "id": 231
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "Betmen",
            "id": 232
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "দ্য ব্যাটম্যান",
            "id": 233
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "द बैटमैन",
            "id": 234
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "バットマン",
            "id": 235
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "Batman: Vạch Trần Sự Thật",
            "id": 236
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "ザ・バットマン",
            "id": 237
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "הבאטמן",
            "id": 238
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "Betmens",
            "id": 239
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "THE BATMAN－ザ・バットマン－：2022",
            "id": 240
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "الرجل الوطواط",
            "id": 241
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "الرجل الخفاش",
            "id": 242
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "The Batman: 1",
            "id": 243
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "Բեթմենը",
            "id": 283
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "蝙蝠侠8：新蝙蝠侠",
            "id": 297
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 67,
            "title": "လင်းနို့လူသား",
            "id": 348
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "batman",
        "sizeOnDisk": 3487908744,
        "status": "released",
        "overview": "In his second year of fighting crime, Batman uncovers corruption in Gotham City that connects to his own family while facing a serial killer known as the Riddler.",
        "inCinemas": "2022-03-01T00:00:00Z",
        "physicalRelease": "2022-05-24T00:00:00Z",
        "digitalRelease": "2022-04-17T00:00:00Z",
        "releaseDate": "2022-04-17T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/40/poster.jpg?lastWrite=638700681021517356",
            "remoteUrl": "https://image.tmdb.org/t/p/original/74xTEgt7R36Fpooo50r9T25onhq.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/40/fanart.jpg?lastWrite=638797515601386381",
            "remoteUrl": "https://image.tmdb.org/t/p/original/rvtdN5XkWAfGX6xDuPL6yYS2seK.jpg"
          }
        ],
        "website": "https://www.thebatman.com",
        "year": 2022,
        "youTubeTrailerId": "vc7_mH2PWHs",
        "studio": "6th & Idaho Motion Picture Company",
        "path": "/movies/The Batman (2022)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 39,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/The Batman (2022)",
        "runtime": 177,
        "cleanTitle": "thebatman",
        "imdbId": "tt1877830",
        "tmdbId": 414906,
        "titleSlug": "414906",
        "rootFolderPath": "/movies/",
        "certification": "PG-13",
        "genres": [
          "Crime",
          "Mystery",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-11-19T22:16:15Z",
        "ratings": {
          "imdb": {
            "votes": 873881,
            "value": 7.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 10952,
            "value": 7.657,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 72,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 85,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 40,
          "relativePath": "The Batman (2022).mp4",
          "path": "/movies/The Batman (2022)/The Batman (2022).mp4",
          "size": 3487908744,
          "dateAdded": "2024-11-19T22:25:11Z",
          "sceneName": "The Batman (2022) [1080p] [BluRay] [5.1] [YTS.MX]",
          "releaseGroup": "YTS.MX",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 7,
              "name": "Bluray-1080p",
              "source": "bluray",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 384000,
            "audioChannels": 5.1,
            "audioCodec": "AAC",
            "audioLanguages": "und",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 2250091,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:56:11",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "The Batman (2022) [1080p] [BluRay] [5.1] [YTS.MX]/The.Batman.2022.1080p.BluRay.x264.AAC5.1-[YTS.MX].mp4",
          "qualityCutoffNotMet": false,
          "id": 39
        },
        "collection": {
          "title": "The Batman Collection",
          "tmdbId": 948485
        },
        "popularity": 25.0982,
        "lastSearchTime": "2024-11-19T22:16:53Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 3487908744,
          "releaseGroups": [
            "YTS.MX"
          ]
        },
        "id": 40
      },
      {
        "title": "Deadpool",
        "originalTitle": "Deadpool",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 13,
            "title": "Quái Nhân Deadpool",
            "id": 244
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 13,
            "title": "Deadpool: 1",
            "id": 247
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 13,
            "title": "死侍1",
            "id": 298
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "deadpool",
        "sizeOnDisk": 2213955524,
        "status": "released",
        "overview": "The origin story of former Special Forces operative turned mercenary Wade Wilson, who, after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.",
        "inCinemas": "2016-02-09T00:00:00Z",
        "physicalRelease": "2016-05-10T00:00:00Z",
        "digitalRelease": "2016-02-12T00:00:00Z",
        "releaseDate": "2016-02-12T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/41/poster.jpg?lastWrite=638795787404274879",
            "remoteUrl": "https://image.tmdb.org/t/p/original/3E53WEZJqP6aM84D8CckXx4pIHw.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/41/fanart.jpg?lastWrite=638804428313012898",
            "remoteUrl": "https://image.tmdb.org/t/p/original/en971MEXui9diirXlogOrPKmsEn.jpg"
          }
        ],
        "website": "https://www.20thcenturystudios.com/movies/deadpool",
        "year": 2016,
        "youTubeTrailerId": "9vN6DHB6bJc",
        "studio": "20th Century Fox",
        "path": "/movies/Deadpool (2016)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 41,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Deadpool (2016)",
        "runtime": 108,
        "cleanTitle": "deadpool",
        "imdbId": "tt1431045",
        "tmdbId": 293660,
        "titleSlug": "293660",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Action",
          "Adventure",
          "Comedy"
        ],
        "tags": [],
        "added": "2024-11-24T14:09:40Z",
        "ratings": {
          "imdb": {
            "votes": 1209570,
            "value": 8,
            "type": "user"
          },
          "tmdb": {
            "votes": 31644,
            "value": 7.6,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 65,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 85,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 41,
          "relativePath": "Deadpool (2016).mp4",
          "path": "/movies/Deadpool (2016)/Deadpool (2016).mp4",
          "size": 2213955524,
          "dateAdded": "2024-11-24T14:18:37Z",
          "sceneName": "Deadpool.2016.RERIP.PROPER.1080p.BluRay.H264.AAC-LAMA[TGx]",
          "releaseGroup": "LAMA",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 7,
              "name": "Bluray-1080p",
              "source": "bluray",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 2,
              "real": 0,
              "isRepack": true
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 224000,
            "audioChannels": 5.1,
            "audioCodec": "AAC",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 2499742,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x808",
            "runTime": "1:48:06",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "Deadpool.2016.RERIP.PROPER.1080p.BluRay.H264.AAC-LAMA[TGx]/Deadpool.2016.RERIP.PROPER.1080p.BluRay.H264.AAC-LAMA.mp4",
          "qualityCutoffNotMet": false,
          "id": 41
        },
        "collection": {
          "title": "Deadpool Collection",
          "tmdbId": 448150
        },
        "popularity": 56.014,
        "lastSearchTime": "2024-11-24T14:10:01Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2213955524,
          "releaseGroups": [
            "LAMA"
          ]
        },
        "id": 41
      },
      {
        "title": "Deadpool 2",
        "originalTitle": "Deadpool 2",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 14,
            "title": "Deadpool: Number Two",
            "id": 248
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 14,
            "title": "เดดพูล 2",
            "id": 249
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 14,
            "title": "Deadpool 2: Super Duper Cut",
            "id": 250
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 14,
            "title": "死侍2",
            "id": 251
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 14,
            "title": "Quái Nhân Deadpool 2",
            "id": 252
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "deadpool 2",
        "sizeOnDisk": 3632115302,
        "status": "released",
        "overview": "Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.",
        "inCinemas": "2018-05-15T00:00:00Z",
        "physicalRelease": "2018-08-21T00:00:00Z",
        "digitalRelease": "2018-05-18T00:00:00Z",
        "releaseDate": "2018-05-18T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/42/poster.jpg?lastWrite=638680541844372976",
            "remoteUrl": "https://image.tmdb.org/t/p/original/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/42/fanart.jpg?lastWrite=638826986199772688",
            "remoteUrl": "https://image.tmdb.org/t/p/original/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg"
          }
        ],
        "website": "https://www.20thcenturystudios.com/movies/deadpool-2",
        "year": 2018,
        "youTubeTrailerId": "20bpjtCbCz0",
        "studio": "Maximum Effort",
        "path": "/movies/Deadpool 2 (2018)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 42,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Deadpool 2 (2018)",
        "runtime": 120,
        "cleanTitle": "deadpool2",
        "imdbId": "tt5463162",
        "tmdbId": 383498,
        "titleSlug": "383498",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Action",
          "Comedy",
          "Adventure"
        ],
        "tags": [],
        "added": "2024-11-24T14:09:43Z",
        "ratings": {
          "imdb": {
            "votes": 715099,
            "value": 7.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 18406,
            "value": 7.491,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 66,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 84,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 42,
          "relativePath": "Deadpool 2 (2018).mkv",
          "path": "/movies/Deadpool 2 (2018)/Deadpool 2 (2018).mkv",
          "size": 3632115302,
          "dateAdded": "2024-11-24T15:58:05Z",
          "sceneName": "Deadpool 2 2018 Super Duper Cut UNRATED 1080p BluRay AC3 5.1 x264 CLEANED",
          "edition": "UNRATED",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 7,
              "name": "Bluray-1080p",
              "source": "bluray",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 448000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:13:24",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "Deadpool 2 2018 Super Duper Cut UNRATED 1080p BluRay AC3 5.1 x264 CLEANED.mkv/Deadpool 2 2018 Super Duper Cut UNRATED 1080p BluRay AC3 5.1 x264 CLEANED.mkv",
          "qualityCutoffNotMet": false,
          "id": 42
        },
        "collection": {
          "title": "Deadpool Collection",
          "tmdbId": 448150
        },
        "popularity": 96.4768,
        "lastSearchTime": "2024-11-24T14:11:10Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 3632115302,
          "releaseGroups": []
        },
        "id": 42
      },
      {
        "title": "Killer Heat",
        "originalTitle": "Killer Heat",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 69,
            "title": "The Jealousy Man",
            "id": 253
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 69,
            "title": "گرمای کشنده",
            "id": 254
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 69,
            "title": "آفتاب سوزان",
            "id": 255
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "killer heat",
        "sizeOnDisk": 2558376801,
        "status": "released",
        "overview": "An expat PI is hired to investigate a suspicious death in Crete, Greece, where jealousies run deep amongst the victim's powerful family.",
        "digitalRelease": "2024-09-25T00:00:00Z",
        "releaseDate": "2024-09-25T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/43/poster.jpg?lastWrite=638833035355587528",
            "remoteUrl": "https://image.tmdb.org/t/p/original/WiAEiqelck0NGWplhL5JQR12eg.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/43/fanart.jpg?lastWrite=638800107873727086",
            "remoteUrl": "https://image.tmdb.org/t/p/original/994i0ocQkO6X10vQPA4ptueEFlh.jpg"
          }
        ],
        "website": "https://www.amazon.com/dp/B0D2M5W9JD",
        "year": 2024,
        "youTubeTrailerId": "ADGSIaE6nzE",
        "studio": "Makeready",
        "path": "/movies/Killer Heat (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 43,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Killer Heat (2024)",
        "runtime": 97,
        "cleanTitle": "killerheat",
        "imdbId": "tt27419292",
        "tmdbId": 1108566,
        "titleSlug": "1108566",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Crime",
          "Drama",
          "Romance"
        ],
        "tags": [],
        "added": "2024-11-27T03:14:20Z",
        "ratings": {
          "imdb": {
            "votes": 13608,
            "value": 5.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 267,
            "value": 5.773,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 33,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 18,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 43,
          "relativePath": "Killer Heat (2024).mkv",
          "path": "/movies/Killer Heat (2024)/Killer Heat (2024).mkv",
          "size": 2558376801,
          "dateAdded": "2024-11-27T03:22:53Z",
          "sceneName": "Killer Heat (2024) iTA-ENG.WEBDL.1080p.x264-Dr4gon",
          "releaseGroup": "Dr4gon",
          "edition": "",
          "languages": [
            {
              "id": 5,
              "name": "Italian"
            },
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 640000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "ita/eng",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "1:36:31",
            "scanType": "Progressive",
            "subtitles": "ita/ita/eng"
          },
          "originalFilePath": "Killer Heat (2024) iTA-ENG.WEBDL.1080p.x264-Dr4gon.mkv",
          "qualityCutoffNotMet": false,
          "id": 43
        },
        "popularity": 5.3985,
        "lastSearchTime": "2024-11-27T03:15:12Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2558376801,
          "releaseGroups": [
            "Dr4gon"
          ]
        },
        "id": 43
      },
      {
        "title": "Lucky Baskhar",
        "originalTitle": "లక్కీ భాస్కర్‌",
        "originalLanguage": {
          "id": 45,
          "name": "Telugu"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 70,
            "title": "باسکار خوش شانس",
            "id": 263
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "lucky baskhar",
        "sizeOnDisk": 3355527572,
        "status": "released",
        "overview": "A cash-strapped bank cashier embarks on a risky investment scheme and soon gets drawn into the murky world of money laundering.",
        "inCinemas": "2024-10-30T00:00:00Z",
        "releaseDate": "2025-01-28T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/44/poster.jpg?lastWrite=638852909637603101",
            "remoteUrl": "https://image.tmdb.org/t/p/original/a47JQFl9L7VDa79tEvnTOJe0rPa.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/44/fanart.jpg?lastWrite=638703273707443302",
            "remoteUrl": "https://image.tmdb.org/t/p/original/mjg6Z4IZOGvcLUgNCPuow22wTvm.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "Kv5RKsqVe-Y",
        "studio": "Sithara Entertainments",
        "path": "/movies/Lucky Baskhar (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 44,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Lucky Baskhar (2024)",
        "runtime": 148,
        "cleanTitle": "luckybaskhar",
        "imdbId": "tt27540542",
        "tmdbId": 1239511,
        "titleSlug": "1239511",
        "rootFolderPath": "/movies/",
        "certification": "NR",
        "genres": [
          "Drama",
          "Thriller",
          "Crime"
        ],
        "tags": [],
        "added": "2024-12-03T01:27:40Z",
        "ratings": {
          "imdb": {
            "votes": 32168,
            "value": 8,
            "type": "user"
          },
          "tmdb": {
            "votes": 45,
            "value": 7.511,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 44,
          "relativePath": "Lucky Baskhar (2024).mkv",
          "path": "/movies/Lucky Baskhar (2024)/Lucky Baskhar (2024).mkv",
          "size": 3355527572,
          "dateAdded": "2024-12-03T02:08:50Z",
          "sceneName": "www.1TamilBlasters.my - Lucky Baskhar (2024)[1080p HD AVC UNTOUCHED - x264 - [Mal + Kan + Hin] - DDP5.1(192Kbps) - 3.1GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            },
            {
              "id": 49,
              "name": "Kannada"
            },
            {
              "id": 26,
              "name": "Hindi"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/kan/hin",
            "audioStreamCount": 3,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "2:27:56",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.my - Lucky Baskhar (2024)[1080p HD AVC UNTOUCHED - x264 - [Mal + Kan + Hin] - DDP5.1(192Kbps) - 3.1GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 44
        },
        "popularity": 4.099,
        "lastSearchTime": "2024-12-03T01:28:01Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 3355527572,
          "releaseGroups": []
        },
        "id": 44
      },
      {
        "title": "Level Cross",
        "originalTitle": "ലെവെൽ ക്രോസ്",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "level cross",
        "sizeOnDisk": 1579292970,
        "status": "released",
        "overview": "In a desolate desert, a reclusive gatekeeper offers refuge to a mysterious woman fleeing a dark past, leading to an unraveling of secrets and shattered realities.",
        "inCinemas": "2024-07-26T00:00:00Z",
        "releaseDate": "2024-10-24T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/45/poster.jpg?lastWrite=638795787414915675",
            "remoteUrl": "https://image.tmdb.org/t/p/original/qBtytEZyFKZhLk2UCzIJuOda7Fu.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/45/fanart.jpg?lastWrite=638853773689618547",
            "remoteUrl": "https://image.tmdb.org/t/p/original/w3SefSCyySZkFBISwabtmfAkDWG.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Abhishek Films",
        "path": "/movies/Level Cross (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 45,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Level Cross (2024)",
        "runtime": 114,
        "cleanTitle": "levelcross",
        "imdbId": "tt27328373",
        "tmdbId": 1105682,
        "titleSlug": "1105682",
        "rootFolderPath": "/movies/",
        "genres": [
          "Thriller",
          "Drama"
        ],
        "tags": [],
        "added": "2024-12-03T01:33:01Z",
        "ratings": {
          "imdb": {
            "votes": 2688,
            "value": 6.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 8,
            "value": 6.6,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 45,
          "relativePath": "Level Cross (2024).mkv",
          "path": "/movies/Level Cross (2024)/Level Cross (2024).mkv",
          "size": 1579292970,
          "dateAdded": "2024-12-03T04:49:54Z",
          "sceneName": "www.1TamilBlasters.dad - Level Cross (2024) [1080p HD HEVC - x265 - [Tam(DDP5.1 -384Kbps) + Mal + Tel + Kan + Hin] - DDP2.0(224Kbps) - 1.5GB - ESub]",
          "releaseGroup": "384Kbps",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            },
            {
              "id": 48,
              "name": "Malayalam"
            },
            {
              "id": 45,
              "name": "Telugu"
            },
            {
              "id": 49,
              "name": "Kannada"
            },
            {
              "id": 26,
              "name": "Hindi"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 384000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "tam/mal/tel/kan/hin",
            "audioStreamCount": 5,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "1:54:45",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.dad - Level Cross (2024) [1080p HD HEVC - x265 - [Tam(DDP5.1 -384Kbps) + Mal + Tel + Kan + Hin] - DDP2.0(224Kbps) - 1.5GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 45
        },
        "popularity": 0.6353,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1579292970,
          "releaseGroups": [
            "384Kbps"
          ]
        },
        "id": 45
      },
      {
        "title": "Bougainvillea",
        "originalTitle": "ബോഗയ്ൻവില്ല",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "bougainvillea",
        "sizeOnDisk": 3325928318,
        "status": "released",
        "overview": "A family entangled in a police investigation surrounding the mysterious disappearance of tourists in Kerala.",
        "inCinemas": "2024-10-17T00:00:00Z",
        "digitalRelease": "2024-12-12T00:00:00Z",
        "releaseDate": "2024-12-12T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/46/poster.jpg?lastWrite=638845132523956448",
            "remoteUrl": "https://image.tmdb.org/t/p/original/lH5bWsODh1QU6aia1ZpaC79kq2j.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/46/fanart.jpg?lastWrite=638799243824417041",
            "remoteUrl": "https://image.tmdb.org/t/p/original/c6jcJXaRek3yEgpHoELLptnl4RQ.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Amal Neerad Productions",
        "path": "/movies/Bougainvillea (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 46,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Bougainvillea (2024)",
        "runtime": 138,
        "cleanTitle": "bougainvillea",
        "imdbId": "tt32592802",
        "tmdbId": 1177224,
        "titleSlug": "1177224",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-12-15T16:27:51Z",
        "ratings": {
          "imdb": {
            "votes": 3314,
            "value": 6.4,
            "type": "user"
          },
          "tmdb": {
            "votes": 9,
            "value": 6.6,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 46,
          "relativePath": "Bougainvillea (2024).mkv",
          "path": "/movies/Bougainvillea (2024)/Bougainvillea (2024).mkv",
          "size": 3325928318,
          "dateAdded": "2024-12-15T16:48:01Z",
          "sceneName": "www.1TamilBlasters.wales - Bougainvillea (2024)[Malayalam - 1080p HD AVC UNTOUCHED - x264 - [DDP5.1(448Kbps) ATOMS + AAC] - 3.1GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 448000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3 Atmos",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "AVC",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "2:16:25",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.wales - Bougainvillea (2024)[Malayalam - 1080p HD AVC UNTOUCHED - x264 - [DDP5.1(448Kbps) ATOMS + AAC] - 3.1GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 46
        },
        "popularity": 0.9268,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 3325928318,
          "releaseGroups": []
        },
        "id": 46
      },
      {
        "title": "Sookshmadarshini",
        "originalTitle": "സൂക്ഷ്മദര്‍ശിനി",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 73,
            "title": "放大镜",
            "id": 270
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "sookshmadarshini",
        "sizeOnDisk": 1835774010,
        "status": "released",
        "overview": "Manuel returns with his mother to their former home in a middle-class neighbourhood. Suspicious of his intentions, Priyadarshini and her friends begin gathering clues, convinced he may be hiding something sinister.",
        "inCinemas": "2024-11-22T00:00:00Z",
        "digitalRelease": "2025-01-11T00:00:00Z",
        "releaseDate": "2025-01-11T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/47/poster.jpg?lastWrite=638844268370388096",
            "remoteUrl": "https://image.tmdb.org/t/p/original/8otz5n5ZJZC3krbIiEIA8mhep0f.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/47/fanart.jpg?lastWrite=638705131613196282",
            "remoteUrl": "https://image.tmdb.org/t/p/original/jVbNeG56WLuCncRlPsF7jAGZw1w.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "IrkfzvO9LkE",
        "studio": "Happy Hours Entertainments",
        "path": "/movies/Sookshmadarshini (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 47,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Sookshmadarshini (2024)",
        "runtime": 142,
        "cleanTitle": "sookshmadarshini",
        "imdbId": "tt32495687",
        "tmdbId": 950075,
        "titleSlug": "950075",
        "rootFolderPath": "/movies/",
        "genres": [
          "Mystery",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-12-23T01:12:40Z",
        "ratings": {
          "imdb": {
            "votes": 10755,
            "value": 7.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 20,
            "value": 7.4,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 47,
          "relativePath": "Sookshmadarshini (2024).mkv",
          "path": "/movies/Sookshmadarshini (2024)/Sookshmadarshini (2024).mkv",
          "size": 1835774010,
          "dateAdded": "2024-12-23T02:20:43Z",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            },
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x816",
            "runTime": "2:20:53",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "www.1TamilBlasters.wales - Sookshamadharshini (2024) [Malayalam - 1080p HQ HEVC - x264 - AAC - 1.7GB - Esub].mkv",
          "qualityCutoffNotMet": false,
          "id": 47
        },
        "popularity": 1.7754,
        "lastSearchTime": "2024-12-23T01:25:13Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1835774010,
          "releaseGroups": []
        },
        "id": 47
      },
      {
        "title": "Mura",
        "originalTitle": "മുറ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "mura",
        "sizeOnDisk": 3194512264,
        "status": "released",
        "overview": "In Trivandrum, four inseperable friends, from raw, rustic background Anandhu, Saji, Manu, and Manaf plan the ultimate heist, their one shot at turning dreams into reality. But as they dive deeper, shadows from the past surface, unraveling hidden motives and testing loyalties in ways they never saw coming. When friendship clashes with ambition, how far will they go for revenge?",
        "inCinemas": "2024-11-08T00:00:00Z",
        "releaseDate": "2025-02-06T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/48/poster.jpg?lastWrite=638833035357187646",
            "remoteUrl": "https://image.tmdb.org/t/p/original/7UOVrVNUK1fYqOVcapM0cJz1l8A.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/48/fanart.jpg?lastWrite=638833035358067710",
            "remoteUrl": "https://image.tmdb.org/t/p/original/kqtZibECPpp6tKGBZPPDqdbYD17.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "btEgr48QE2I",
        "studio": "HR Pictures",
        "path": "/movies/Mura (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 48,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Mura (2024)",
        "runtime": 129,
        "cleanTitle": "mura",
        "imdbId": "tt33294237",
        "tmdbId": 1228693,
        "titleSlug": "1228693",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Thriller"
        ],
        "tags": [],
        "added": "2024-12-24T01:02:01Z",
        "ratings": {
          "imdb": {
            "votes": 6304,
            "value": 7.3,
            "type": "user"
          },
          "tmdb": {
            "votes": 4,
            "value": 5.625,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 48,
          "relativePath": "Mura (2024).mkv",
          "path": "/movies/Mura (2024)/Mura (2024).mkv",
          "size": 3194512264,
          "dateAdded": "2024-12-24T03:22:08Z",
          "sceneName": "www.1TamilBlasters.mom - Mura (2024)[Malayalam - 1080p HQ HDRip - x264 - [DDP5.1(192Kbps) + AAC] - 2.9GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 640000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:07:01",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.mom - Mura (2024)[Malayalam - 1080p HQ HDRip - x264 - [DDP5.1(192Kbps) + AAC] - 2.9GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 48
        },
        "popularity": 0.9185,
        "lastSearchTime": "2024-12-24T01:26:22Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 3194512264,
          "releaseGroups": []
        },
        "id": 48
      },
      {
        "title": "ED: Extra Decent",
        "originalTitle": "ഇഡി: എക്‌സ്‌ട്രാ ഡീസൻ്റ്",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "ed extra decent",
        "sizeOnDisk": 996009508,
        "status": "released",
        "overview": "A controlling son's family try to prevent him from regaining his memory after he is hospitalised following a blow to the head.",
        "inCinemas": "2024-12-20T00:00:00Z",
        "releaseDate": "2025-03-20T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/49/poster.jpg?lastWrite=638820936686580232",
            "remoteUrl": "https://image.tmdb.org/t/p/original/1gmWyvloi9znKCYp8fgvEAi02Qy.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/49/fanart.jpg?lastWrite=638714488805023752",
            "remoteUrl": "https://image.tmdb.org/t/p/original/bxkGSdY7hw9DuZhDKlxjNSVFPvd.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Magic Frames",
        "path": "/movies/E D - Extra Decent (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 49,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/E D - Extra Decent (2024)",
        "runtime": 122,
        "cleanTitle": "edextradecent",
        "imdbId": "tt32480186",
        "tmdbId": 1296484,
        "titleSlug": "1296484",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama",
          "Comedy"
        ],
        "tags": [],
        "added": "2025-01-01T20:49:32Z",
        "ratings": {
          "imdb": {
            "votes": 2244,
            "value": 6.1,
            "type": "user"
          },
          "tmdb": {
            "votes": 2,
            "value": 6,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 49,
          "relativePath": "E D - Extra Decent (2024).mkv",
          "path": "/movies/E D - Extra Decent (2024)/E D - Extra Decent (2024).mkv",
          "size": 996009508,
          "dateAdded": "2025-01-01T20:51:06Z",
          "sceneName": "www.1TamilBlasters.party - ED Extra Decent (2024) Malayalam 1080p HEVC HDRip AAC x264 950MB",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "mal",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "HEVC",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x816",
            "runTime": "2:03:03",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "www.1TamilBlasters.party - ED Extra Decent (2024) Malayalam 1080p HEVC HDRip AAC x264 950MB.mkv",
          "qualityCutoffNotMet": false,
          "id": 49
        },
        "popularity": 0.7054,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 996009508,
          "releaseGroups": []
        },
        "id": 49
      },
      {
        "title": "Marco",
        "originalTitle": "മാർക്കോ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 76,
            "title": "Marco 2024",
            "id": 268
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "marco",
        "sizeOnDisk": 4661218605,
        "status": "released",
        "overview": "The adoptive son of the Adattu family, Marco, sets off on a ruthless quest for vengeance after his brother is brutally murdered, finding only betrayal, loss and unimaginable brutality at every step.",
        "inCinemas": "2024-12-20T00:00:00Z",
        "releaseDate": "2025-03-20T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/50/poster.jpg?lastWrite=638802700071510983",
            "remoteUrl": "https://image.tmdb.org/t/p/original/il3ao5gcF6fZNqo1o9o7lusmEyU.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/50/fanart.jpg?lastWrite=638746484052085663",
            "remoteUrl": "https://image.tmdb.org/t/p/original/n89fJotmgkDvr5pF2OBqMLp7ZG7.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "4VQdzTv8E-g",
        "studio": "Cubes Entertainments",
        "path": "/movies/Marco (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 50,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Marco (2024)",
        "runtime": 145,
        "cleanTitle": "marco",
        "imdbId": "tt29383379",
        "tmdbId": 1186350,
        "titleSlug": "1186350",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Crime",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-01-14T01:59:56Z",
        "ratings": {
          "imdb": {
            "votes": 22175,
            "value": 6.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 33,
            "value": 6.1,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 50,
          "relativePath": "Marco (2024).mkv",
          "path": "/movies/Marco (2024)/Marco (2024).mkv",
          "size": 4661218605,
          "dateAdded": "2025-01-14T02:43:22Z",
          "sceneName": "www.1TamilBlasters.party - Marco (2024)[Malayalam - 1080p HQ HDRip - x264 - AAC - 4.5GB - HQ Line Audio]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "mal",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x816",
            "runTime": "2:19:26",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "www.1TamilBlasters.party - Marco (2024)[Malayalam - 1080p HQ HDRip - x264 - AAC - 4.5GB - HQ Line Audio].mkv",
          "qualityCutoffNotMet": false,
          "id": 50
        },
        "collection": {
          "title": "Marco Collection",
          "tmdbId": 1407785
        },
        "popularity": 4.2996,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 4661218605,
          "releaseGroups": []
        },
        "id": 50
      },
      {
        "title": "Kooman",
        "originalTitle": "കൂമൻ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "kooman",
        "sizeOnDisk": 0,
        "status": "released",
        "overview": "The story takes place in a hilly village on the Kerala-Tamil Nadu border. The story is about a strict police officer who relocates there and the subsequent events that turn his and many other's lives upside down associated with that police station. Few normal incidents happen in the village, and some from the past suddenly appear to be abnormal. The secrets slowly start unfolding.",
        "inCinemas": "2022-11-04T00:00:00Z",
        "releaseDate": "2023-02-02T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/51/poster.jpg?lastWrite=638800107876207272",
            "remoteUrl": "https://image.tmdb.org/t/p/original/nhKiu5zi5rUjPwzEQCaLKfbDHrL.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/51/fanart.jpg?lastWrite=638829578757568019",
            "remoteUrl": "https://image.tmdb.org/t/p/original/y0EpsN8VU5SH31Q5PMpk93UjyK9.jpg"
          }
        ],
        "website": "",
        "year": 2022,
        "youTubeTrailerId": "",
        "studio": "Ananya Films",
        "path": "/movies/Kooman (2022)",
        "qualityProfileId": 1,
        "hasFile": false,
        "movieFileId": 0,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Kooman (2022)",
        "runtime": 151,
        "cleanTitle": "kooman",
        "imdbId": "tt17632818",
        "tmdbId": 933833,
        "titleSlug": "933833",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama",
          "Mystery",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-01-14T17:04:08Z",
        "ratings": {
          "imdb": {
            "votes": 4082,
            "value": 7.3,
            "type": "user"
          },
          "tmdb": {
            "votes": 12,
            "value": 6.8,
            "type": "user"
          }
        },
        "popularity": 0.9514,
        "lastSearchTime": "2025-01-14T17:10:44Z",
        "statistics": {
          "movieFileCount": 0,
          "sizeOnDisk": 0,
          "releaseGroups": []
        },
        "id": 51
      },
      {
        "title": "Pani",
        "originalTitle": "പണി",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "pani",
        "sizeOnDisk": 1827596931,
        "status": "released",
        "overview": "When the peaceful married life of a couple is unexpectedly disrupted by two youngsters with criminal inclination, the trials and tribulations connect the mobster lives of Thrissur by becoming a part of vengeance.",
        "inCinemas": "2024-10-24T00:00:00Z",
        "digitalRelease": "2025-01-14T00:00:00Z",
        "releaseDate": "2025-01-14T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/52/poster.jpg?lastWrite=638814799115468669",
            "remoteUrl": "https://image.tmdb.org/t/p/original/1JQpkfOIrIXhTTbTmzryVX3GZZK.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/52/fanart.jpg?lastWrite=638814799116828803",
            "remoteUrl": "https://image.tmdb.org/t/p/original/mTSnlAlRB5nDWeh3W1ZRFzj8AMg.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Appu Pathu Pappu Production House",
        "path": "/movies/Pani (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 51,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Pani (2024)",
        "runtime": 141,
        "cleanTitle": "pani",
        "imdbId": "tt29461220",
        "tmdbId": 1194788,
        "titleSlug": "1194788",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-01-16T00:08:59Z",
        "ratings": {
          "imdb": {
            "votes": 3193,
            "value": 6.9,
            "type": "user"
          },
          "tmdb": {
            "votes": 6,
            "value": 5.167,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 52,
          "relativePath": "Pani (2024).mkv",
          "path": "/movies/Pani (2024)/Pani (2024).mkv",
          "size": 1827596931,
          "dateAdded": "2025-01-16T00:34:40Z",
          "sceneName": "www.1TamilBlasters.party - Pani (2024) [Malayalam - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.7GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:21:34",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.party - Pani (2024) [Malayalam - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.7GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 51
        },
        "popularity": 2.8611,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1827596931,
          "releaseGroups": []
        },
        "id": 52
      },
      {
        "title": "Rifle Club",
        "originalTitle": "റൈഫിൾ ക്ലബ്ബ്",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 80,
            "title": "کلوب تیراندازی",
            "id": 288
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "rifle club",
        "sizeOnDisk": 2950512846,
        "status": "released",
        "overview": "A historic rifle club in the Western Ghats becomes the center of a thrilling fight for survival when a dangerous arms dealer and his gang come seeking revenge. The club’s members, skilled hunters with a shared passion works together to protect their lives and their legacy",
        "inCinemas": "2024-12-19T00:00:00Z",
        "digitalRelease": "2025-01-16T00:00:00Z",
        "releaseDate": "2025-01-16T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/53/poster.jpg?lastWrite=638815751771865133",
            "remoteUrl": "https://image.tmdb.org/t/p/original/k1czxgmnH63A7old7hL4oNzqYMw.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/53/fanart.jpg?lastWrite=638725829566508258",
            "remoteUrl": "https://image.tmdb.org/t/p/original/lWFFnsSs0DdxX54UPNqTX6sI0gW.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "OPM Dream Mill Cinemas",
        "path": "/movies/Rifle Club (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 53,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Rifle Club (2024)",
        "runtime": 113,
        "cleanTitle": "rifleclub",
        "imdbId": "tt31188121",
        "tmdbId": 1177623,
        "titleSlug": "1177623",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-01-16T00:09:14Z",
        "ratings": {
          "imdb": {
            "votes": 4527,
            "value": 7,
            "type": "user"
          },
          "tmdb": {
            "votes": 11,
            "value": 6.2,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 53,
          "relativePath": "Rifle Club (2024).mkv",
          "path": "/movies/Rifle Club (2024)/Rifle Club (2024).mkv",
          "size": 2950512846,
          "dateAdded": "2025-01-17T03:10:20Z",
          "sceneName": "www.1TamilBlasters.party - Rifle Club (2024) [Malayalam - 1080p HQ HDRip - x264 - [DDP 5.1 (640Kbps) + AAC] - 2.7GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 640000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x802",
            "runTime": "1:52:24",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "www.1TamilBlasters.party - Rifle Club (2024) [Malayalam - 1080p HQ HDRip - x264 - [DDP 5.1 (640Kbps) + AAC] - 2.7GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 53
        },
        "popularity": 4.2539,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2950512846,
          "releaseGroups": []
        },
        "id": 53
      },
      {
        "title": "Anand Sreebala",
        "originalTitle": "ആനന്ദ് ശ്രീബാല",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "anand sreebala",
        "sizeOnDisk": 2483923056,
        "status": "released",
        "overview": "Follows the missing person case of Merin Joy and how an ordinary man with a tragic past gets wrapped in the investigation.",
        "inCinemas": "2024-11-15T00:00:00Z",
        "releaseDate": "2025-02-13T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/54/poster.jpg?lastWrite=638729120316921974",
            "remoteUrl": "https://image.tmdb.org/t/p/original/gnt2GVTgwbiY63HQtIE5VsFQNxU.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/54/fanart.jpg?lastWrite=638729120317882047",
            "remoteUrl": "https://image.tmdb.org/t/p/original/fcJO190JXVfFQaF04RWYqugLDrm.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Kavya Film Company",
        "path": "/movies/Anand Sreebala (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 54,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Anand Sreebala (2024)",
        "runtime": 134,
        "cleanTitle": "anandsreebala",
        "imdbId": "tt31416854",
        "tmdbId": 1243975,
        "titleSlug": "1243975",
        "rootFolderPath": "/movies/",
        "genres": [
          "Thriller",
          "Mystery",
          "Crime"
        ],
        "tags": [],
        "added": "2025-01-19T19:33:51Z",
        "ratings": {
          "imdb": {
            "votes": 2415,
            "value": 6.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 4,
            "value": 6,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 54,
          "relativePath": "Anand Sreebala (2024).mkv",
          "path": "/movies/Anand Sreebala (2024)/Anand Sreebala (2024).mkv",
          "size": 2483923056,
          "dateAdded": "2025-01-19T19:45:50Z",
          "sceneName": "www.1TamilBlasters.party - Anand Sreebala (2024) [Malayalam - 1080p HQ HDRip - x264 - [DDP 5.1 (640Kbps) + AAC] - 2.3GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 640000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x816",
            "runTime": "2:13:06",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "www.1TamilBlasters.party - Anand Sreebala (2024) [Malayalam - 1080p HQ HDRip - x264 - [DDP 5.1 (640Kbps) + AAC] - 2.3GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 54
        },
        "popularity": 0.6812,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2483923056,
          "releaseGroups": []
        },
        "id": 54
      },
      {
        "title": "Vikram",
        "originalTitle": "விக்ரம்",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "vikram",
        "sizeOnDisk": 2438529626,
        "status": "released",
        "overview": "Amar is assigned to investigate a case of serial killings. When Amar investigates the case, he realizes it is not what it seems to be and following down this path will lead to nothing but war between everyone involved.",
        "inCinemas": "2022-06-02T00:00:00Z",
        "digitalRelease": "2022-07-08T00:00:00Z",
        "releaseDate": "2022-07-08T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/55/poster.jpg?lastWrite=638823529357725517",
            "remoteUrl": "https://image.tmdb.org/t/p/original/774UV1aCURb4s4JfEFg3IEMu5Zj.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/55/fanart.jpg?lastWrite=638734502312677252",
            "remoteUrl": "https://image.tmdb.org/t/p/original/dkIX4dSMuVqjfrPGunBJUR7K3LQ.jpg"
          }
        ],
        "website": "",
        "year": 2022,
        "youTubeTrailerId": "",
        "studio": "Raajkamal Films International",
        "path": "/movies/Vikram (2022)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 55,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Vikram (2022)",
        "runtime": 174,
        "cleanTitle": "vikram",
        "imdbId": "tt9179430",
        "tmdbId": 743563,
        "titleSlug": "743563",
        "rootFolderPath": "/movies/",
        "certification": "PG-13",
        "genres": [
          "Action",
          "Crime",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-01-26T01:03:50Z",
        "ratings": {
          "imdb": {
            "votes": 80874,
            "value": 8.3,
            "type": "user"
          },
          "tmdb": {
            "votes": 127,
            "value": 7.7,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 59,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 55,
          "relativePath": "Vikram (2022).mkv",
          "path": "/movies/Vikram (2022)/Vikram (2022).mkv",
          "size": 2438529626,
          "dateAdded": "2025-01-26T10:12:46Z",
          "sceneName": "Vikram.(2022).DUAL.1080p.DS4K.WEBRip.10bit.DDP.Atmos.5.1-[Musafirboy]",
          "releaseGroup": "Musafirboy",
          "edition": "",
          "languages": [
            {
              "id": 26,
              "name": "Hindi"
            },
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "hin/tam",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "h265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x816",
            "runTime": "2:51:10",
            "scanType": "Progressive",
            "subtitles": "eng/hin/tam/tel/may/kan"
          },
          "originalFilePath": "Vikram.(2022).DUAL.1080p.DS4K.WEBRip.10bit.DDP.Atmos.5.1-[Musafirboy]/Vikram.(2022).DUAL.1080p.DS4K.WEBRip.10bit.DDP.Atmos.5.1-[Musafirboy].mkv",
          "qualityCutoffNotMet": false,
          "id": 55
        },
        "popularity": 2.911,
        "lastSearchTime": "2025-01-26T01:04:14Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2438529626,
          "releaseGroups": [
            "Musafirboy"
          ]
        },
        "id": 55
      },
      {
        "title": "Moana 2",
        "originalTitle": "Moana 2",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 83,
            "title": "Moana: Um Mar de Aventuras 2",
            "id": 277
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 83,
            "title": "Маана 2",
            "id": 278
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 83,
            "title": "モアナ２",
            "id": 279
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 83,
            "title": "莫阿娜2",
            "id": 280
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 83,
            "title": "Vaiana 2",
            "id": 281
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 83,
            "title": "海洋奇緣2",
            "id": 282
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 83,
            "title": "Մոանա 2",
            "id": 286
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 83,
            "title": "海洋奇缘2",
            "id": 305
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 83,
            "title": "موانا ٢",
            "id": 307
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "moana 2",
        "sizeOnDisk": 5760453881,
        "status": "released",
        "overview": "After receiving an unexpected call from her wayfinding ancestors, Moana journeys alongside Maui and a new crew to the far seas of Oceania and into dangerous, long-lost waters for an adventure unlike anything she's ever faced.",
        "inCinemas": "2024-11-21T00:00:00Z",
        "physicalRelease": "2025-03-17T00:00:00Z",
        "digitalRelease": "2025-01-27T00:00:00Z",
        "releaseDate": "2025-01-27T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/56/poster.jpg?lastWrite=638738706951585139",
            "remoteUrl": "https://image.tmdb.org/t/p/original/aLVkiINlIeCkcZIzb7XHzPYgO6L.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/56/fanart.jpg?lastWrite=638749940596119066",
            "remoteUrl": "https://image.tmdb.org/t/p/original/zo8CIjJ2nfNOevqNajwMRO6Hwka.jpg"
          }
        ],
        "website": "https://movies.disney.com/moana-2",
        "year": 2024,
        "youTubeTrailerId": "JdSl4RMNtGE",
        "studio": "Walt Disney Pictures",
        "path": "/movies/Moana 2 (2024)",
        "qualityProfileId": 4,
        "hasFile": true,
        "movieFileId": 56,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Moana 2 (2024)",
        "runtime": 100,
        "cleanTitle": "moana2",
        "imdbId": "tt13622970",
        "tmdbId": 1241982,
        "titleSlug": "1241982",
        "rootFolderPath": "/movies/",
        "certification": "PG",
        "genres": [
          "Animation",
          "Adventure",
          "Family",
          "Comedy"
        ],
        "tags": [],
        "added": "2025-01-28T20:05:03Z",
        "ratings": {
          "imdb": {
            "votes": 107631,
            "value": 6.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 2448,
            "value": 7.1,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 58,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 61,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 56,
          "relativePath": "Moana 2 (2024).mp4",
          "path": "/movies/Moana 2 (2024)/Moana 2 (2024).mp4",
          "size": 5760453881,
          "dateAdded": "2025-01-28T20:23:33Z",
          "sceneName": "Moana.2.2024.1080p.WEBRIP.H264.DD2.0.COLLECTiVE",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 381374,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "eng",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 7864320,
            "videoCodec": "h264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x960",
            "runTime": "1:33:06",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "Moana.2.2024.1080p.WEBRIP.H264.DD2.0.COLLECTiVE/Moana.2.2024.1080p.WEBRIP.H264.DD2.0.COLLECTiVE.mp4",
          "qualityCutoffNotMet": false,
          "id": 56
        },
        "collection": {
          "title": "Moana Collection",
          "tmdbId": 1241984
        },
        "popularity": 92.8794,
        "lastSearchTime": "2025-01-28T20:08:58Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 5760453881,
          "releaseGroups": []
        },
        "id": 56
      },
      {
        "title": "Identity",
        "originalTitle": "ഐഡന്റിറ്റി",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "identity",
        "sizeOnDisk": 1860474413,
        "status": "released",
        "overview": "A sketch artist and a cop work together to unravel the identity of an elusive killer using the descriptions of his face, etched into the memory of an eye-witness to the brutal crime",
        "inCinemas": "2025-01-02T00:00:00Z",
        "digitalRelease": "2025-01-28T00:00:00Z",
        "releaseDate": "2025-01-28T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/57/poster.jpg?lastWrite=638791466366900999",
            "remoteUrl": "https://image.tmdb.org/t/p/original/hrusjWrcRuClY6PNooSZiKL6gqv.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/57/fanart.jpg?lastWrite=638739629014551422",
            "remoteUrl": "https://image.tmdb.org/t/p/original/d8fgJIUyvJa0NGkZ7VQBlgJADIK.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Ragam Movies",
        "path": "/movies/Identity (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 57,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Identity (2025)",
        "runtime": 156,
        "cleanTitle": "identity",
        "imdbId": "tt27436132",
        "tmdbId": 1012180,
        "titleSlug": "1012180",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-01-31T23:28:20Z",
        "ratings": {
          "imdb": {
            "votes": 9022,
            "value": 7.3,
            "type": "user"
          },
          "tmdb": {
            "votes": 10,
            "value": 5.6,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 57,
          "relativePath": "Identity (2025).mkv",
          "path": "/movies/Identity (2025)/Identity (2025).mkv",
          "size": 1860474413,
          "dateAdded": "2025-01-31T23:36:12Z",
          "sceneName": "www.1TamilBlasters.men - Identity (2025)[Malayalam - 1080p HQ HDRip HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.7GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x704",
            "runTime": "2:35:52",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.men - Identity (2025)[Malayalam - 1080p HQ HDRip HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.7GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 57
        },
        "popularity": 0.9094,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1860474413,
          "releaseGroups": []
        },
        "id": 57
      },
      {
        "title": "Rekhachithram",
        "originalTitle": "രേഖാചിത്രം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "rekhachithram",
        "sizeOnDisk": 1760709832,
        "status": "released",
        "overview": "Having recently served a suspension for gambling online while on duty, Circle Inspector Vivek Gopinath rejoins the police force and is looking to reclaim his lost honour. Awaiting him is a 40-year-old, unresolved murder mystery with a faceless victim.",
        "inCinemas": "2025-01-09T00:00:00Z",
        "releaseDate": "2025-04-09T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/58/poster.jpg?lastWrite=638768952302050898",
            "remoteUrl": "https://image.tmdb.org/t/p/original/ulIAyiSVQZL1Ov6K2Tjf6wPlzFi.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/58/fanart.jpg?lastWrite=638768788576523685",
            "remoteUrl": "https://image.tmdb.org/t/p/original/97U7d3GwOnDKAKVVbLEq65XyKP3.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Kavya Film Company",
        "path": "/movies/Rekhachithram (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 58,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Rekhachithram (2025)",
        "runtime": 139,
        "cleanTitle": "rekhachithram",
        "imdbId": "tt32284154",
        "tmdbId": 1290954,
        "titleSlug": "1290954",
        "rootFolderPath": "/movies/",
        "genres": [
          "Mystery",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-03-06T17:27:37Z",
        "ratings": {
          "imdb": {
            "votes": 12361,
            "value": 8,
            "type": "user"
          },
          "tmdb": {
            "votes": 19,
            "value": 6.7,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 58,
          "relativePath": "Rekhachithram (2025).mkv",
          "path": "/movies/Rekhachithram (2025)/Rekhachithram (2025).mkv",
          "size": 1760709832,
          "dateAdded": "2025-03-06T17:38:51Z",
          "sceneName": "www.1tamilblasters.rodeo - Rekhachithram (2025) [Malayalam  - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.6GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:16:56",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1tamilblasters.rodeo - Rekhachithram (2025) [Malayalam  - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.6GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 58
        },
        "popularity": 1.4858,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1760709832,
          "releaseGroups": []
        },
        "id": 58
      },
      {
        "title": "Dragon",
        "originalTitle": "டிராகன்",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 88,
            "title": "Return Of The Dragon",
            "id": 304
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 88,
            "title": "Dragon 2025",
            "id": 306
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "dragon",
        "sizeOnDisk": 1852048404,
        "status": "released",
        "overview": "After a top student faces rejection and heartbreak, he cons his way into a finance career. But keeping up the facade proves tricky as the lies build.",
        "inCinemas": "2025-02-21T00:00:00Z",
        "digitalRelease": "2025-03-21T00:00:00Z",
        "releaseDate": "2025-03-21T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/59/poster.jpg?lastWrite=638852909633842824",
            "remoteUrl": "https://image.tmdb.org/t/p/original/b77Su1i74L28InBsyaFlfWPDpeE.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/59/fanart.jpg?lastWrite=638773065055369446",
            "remoteUrl": "https://image.tmdb.org/t/p/original/8y8pxJwYEK1WvQAfoZTwC601eD8.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "AGS Entertainment",
        "path": "/movies/Dragon (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 59,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Dragon (2025)",
        "runtime": 157,
        "cleanTitle": "dragon",
        "imdbId": "tt32080876",
        "tmdbId": 1273049,
        "titleSlug": "1273049",
        "rootFolderPath": "/movies/",
        "genres": [
          "Romance",
          "Comedy",
          "Drama"
        ],
        "tags": [],
        "added": "2025-03-11T16:15:04Z",
        "ratings": {
          "imdb": {
            "votes": 12838,
            "value": 7.9,
            "type": "user"
          },
          "tmdb": {
            "votes": 19,
            "value": 7.9,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 59,
          "relativePath": "Dragon (2025).mkv",
          "path": "/movies/Dragon (2025)/Dragon (2025).mkv",
          "size": 1852048404,
          "dateAdded": "2025-03-11T16:18:35Z",
          "sceneName": "www.1TamilBlasters.rodeo - Dragon (2025)[Tamil - V2 1080p HQ HDRip HEVC - x265 - AAC - 1.7GB]",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "tam",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:32:09",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "www.1TamilBlasters.rodeo - Dragon (2025)[Tamil - V2 1080p HQ HDRip HEVC - x265 - AAC - 1.7GB].mkv",
          "qualityCutoffNotMet": false,
          "id": 59
        },
        "popularity": 5.0486,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1852048404,
          "releaseGroups": []
        },
        "id": 59
      },
      {
        "title": "Ponman",
        "originalTitle": "പൊൻMAN",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "ponman",
        "sizeOnDisk": 1627173946,
        "status": "released",
        "overview": "In a coastal village, gold dealer Ajesh lends 25 sovereigns to Bruno for his sister Steffy's wedding. Chaos ensues when Steffy marries criminal Mariyano, who hoards the gold and tries to eliminate Ajesh. Can Ajesh outsmart  Mariyano?",
        "inCinemas": "2025-01-30T00:00:00Z",
        "digitalRelease": "2025-03-13T00:00:00Z",
        "releaseDate": "2025-03-13T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/60/poster.jpg?lastWrite=638778457896695489",
            "remoteUrl": "https://image.tmdb.org/t/p/original/jWGifR1mYNWPl9TRGgrnj8riajJ.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/60/fanart.jpg?lastWrite=638836491743281459",
            "remoteUrl": "https://image.tmdb.org/t/p/original/imQXxsEn0WZW8WzxtWsfYt7RDL2.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Ajith Vinayaka Films Pvt Ltd",
        "path": "/movies/Ponman (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 60,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Ponman (2025)",
        "runtime": 125,
        "cleanTitle": "ponman",
        "imdbId": "tt30089457",
        "tmdbId": 1244068,
        "titleSlug": "1244068",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama"
        ],
        "tags": [],
        "added": "2025-03-17T00:11:07Z",
        "ratings": {
          "imdb": {
            "votes": 5356,
            "value": 7.4,
            "type": "user"
          },
          "tmdb": {
            "votes": 7,
            "value": 7.4,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 60,
          "relativePath": "Ponman (2025).mkv",
          "path": "/movies/Ponman (2025)/Ponman (2025).mkv",
          "size": 1627173946,
          "dateAdded": "2025-03-17T00:26:35Z",
          "sceneName": "www.1TamilBlasters.rodeo - Ponman (2025)[Malayalam - 1080p HQ HDRip HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.5GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:05:50",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.rodeo - Ponman (2025)[Malayalam - 1080p HQ HDRip HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.5GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 60
        },
        "popularity": 0.8451,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1627173946,
          "releaseGroups": []
        },
        "id": 60
      },
      {
        "title": "Officer on Duty",
        "originalTitle": "ഓഫീസര്‍ ഓണ്‍ ഡ്യൂട്ടി",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "officer on duty",
        "sizeOnDisk": 1650554089,
        "status": "released",
        "overview": "A demoted police inspector investigates a counterfeit jewelry racket, becoming entangled in a dangerous web of crime that puts his life at stake.",
        "inCinemas": "2025-02-20T00:00:00Z",
        "digitalRelease": "2025-03-21T00:00:00Z",
        "releaseDate": "2025-03-21T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/61/poster.jpg?lastWrite=638812206336169262",
            "remoteUrl": "https://image.tmdb.org/t/p/original/ucwirgaK4v9ylQyDkwoXJtDIlf7.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/61/fanart.jpg?lastWrite=638780160226207457",
            "remoteUrl": "https://image.tmdb.org/t/p/original/wBuDEg4hA6dtF96Wiqx0E26HhNd.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Martin Prakkat Films",
        "path": "/movies/Officer on Duty (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 61,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Officer on Duty (2025)",
        "runtime": 134,
        "cleanTitle": "officeronduty",
        "imdbId": "tt34388152",
        "tmdbId": 1281091,
        "titleSlug": "1281091",
        "rootFolderPath": "/movies/",
        "genres": [
          "Crime",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-03-19T21:20:19Z",
        "ratings": {
          "imdb": {
            "votes": 8741,
            "value": 7.5,
            "type": "user"
          },
          "tmdb": {
            "votes": 16,
            "value": 6.3,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 61,
          "relativePath": "Officer on Duty (2025).mkv",
          "path": "/movies/Officer on Duty (2025)/Officer on Duty (2025).mkv",
          "size": 1650554089,
          "dateAdded": "2025-03-19T22:37:01Z",
          "sceneName": "www.1TamilBlasters.rodeo - Officer on Duty (2025) [Malayalam - 1080p HQ HDRip - HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.5GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x808",
            "runTime": "2:14:04",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.rodeo - Officer on Duty (2025) [Malayalam - 1080p HQ HDRip - HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.5GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 61
        },
        "popularity": 3.3164,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1650554089,
          "releaseGroups": []
        },
        "id": 61
      },
      {
        "title": "Kudumbasthan",
        "originalTitle": "குடும்பஸ்தன்",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "kudumbasthan",
        "sizeOnDisk": 1649645230,
        "status": "released",
        "overview": "Naveen's relationship with his parents becomes strained after he marries a oppressed-caste girl. Though they eventually reconcile, his sudden unemployment puts him in a difficult position. As financial pressures mount, Naveen must navigate societal challenges and personal struggles to regain stability and rebuild harmony within his middle-class family.",
        "inCinemas": "2025-01-24T00:00:00Z",
        "digitalRelease": "2025-03-07T00:00:00Z",
        "releaseDate": "2025-03-07T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/62/poster.jpg?lastWrite=638836491739481181",
            "remoteUrl": "https://image.tmdb.org/t/p/original/76AkmAqLNMMJZZWQXQ6KntEiLjK.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/62/fanart.jpg?lastWrite=638836491741521331",
            "remoteUrl": "https://image.tmdb.org/t/p/original/7AA2NJklRlxjixL4VngaQbMsTZ6.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "qfKpPq87bHQ",
        "studio": "Cinemakaaran Productions",
        "path": "/movies/Kudumbasthan (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 62,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Kudumbasthan (2025)",
        "runtime": 153,
        "cleanTitle": "kudumbasthan",
        "imdbId": "tt31958285",
        "tmdbId": 1357713,
        "titleSlug": "1357713",
        "rootFolderPath": "/movies/",
        "genres": [
          "Family",
          "Drama",
          "Comedy"
        ],
        "tags": [],
        "added": "2025-03-23T22:02:30Z",
        "ratings": {
          "imdb": {
            "votes": 2065,
            "value": 7.4,
            "type": "user"
          },
          "tmdb": {
            "votes": 4,
            "value": 7.25,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 62,
          "relativePath": "Kudumbasthan (2025).mkv",
          "path": "/movies/Kudumbasthan (2025)/Kudumbasthan (2025).mkv",
          "size": 1649645230,
          "dateAdded": "2025-03-23T22:40:57Z",
          "sceneName": "www.1TamilBlasters.rodeo - Kudumbasthan (2025)[Tamil - 1080p HQ HDRip HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.5GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "tam/tam",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "HEVC",
            "videoFps": 25,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "2:27:14",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.rodeo - Kudumbasthan (2025)[Tamil - 1080p HQ HDRip HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.5GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 62
        },
        "popularity": 1.8318,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1649645230,
          "releaseGroups": []
        },
        "id": 62
      },
      {
        "title": "Pravinkoodu Shappu",
        "originalTitle": "പ്രാവിൻകൂട് ഷാപ്പു",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "pravinkoodu shappu",
        "sizeOnDisk": 1973836362,
        "status": "released",
        "overview": "On a rainy night, a toddy shop owner is found hanging after 11 people stayed inside playing cards in the closed shop. SI Santhosh investigates, uncovering secrets to find the killer.",
        "inCinemas": "2025-01-16T00:00:00Z",
        "releaseDate": "2025-04-16T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/63/poster.jpg?lastWrite=638783646797150668",
            "remoteUrl": "https://image.tmdb.org/t/p/original/19RY8hiPUklE2UrjQrUiSgyVO5f.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/63/fanart.jpg?lastWrite=638783646800150891",
            "remoteUrl": "https://image.tmdb.org/t/p/original/pRhCiMmPfapBIfHNX9YBzI3QhlQ.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Anwar Rasheed Entertainments",
        "path": "/movies/Pravinkoodu Shappu (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 65,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Pravinkoodu Shappu (2025)",
        "runtime": 146,
        "cleanTitle": "pravinkoodushappu",
        "imdbId": "tt32539176",
        "tmdbId": 1251551,
        "titleSlug": "1251551",
        "rootFolderPath": "/movies/",
        "genres": [
          "Thriller",
          "Crime",
          "Mystery"
        ],
        "tags": [],
        "added": "2025-03-23T22:11:15Z",
        "ratings": {
          "imdb": {
            "votes": 2848,
            "value": 6.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 10,
            "value": 6.8,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 63,
          "relativePath": "Pravinkoodu Shappu (2025).mkv",
          "path": "/movies/Pravinkoodu Shappu (2025)/Pravinkoodu Shappu (2025).mkv",
          "size": 1973836362,
          "dateAdded": "2025-04-10T23:49:48Z",
          "sceneName": "www.1TamilBlasters.red - Pravinkoodu Shappu (2025) [Malayalam  - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.8GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:26:00",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.red - Pravinkoodu Shappu (2025) [Malayalam  - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.8GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 65
        },
        "popularity": 1.196,
        "lastSearchTime": "2025-04-02T17:47:30Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1973836362,
          "releaseGroups": []
        },
        "id": 63
      },
      {
        "title": "The Da Vinci Code",
        "originalTitle": "The Da Vinci Code",
        "originalLanguage": {
          "id": 1,
          "name": "English"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "Da Vinchi Shifresi",
            "id": 308
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "Da Vincijev kod",
            "id": 309
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "Sakrileg",
            "id": 310
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "The DaVinci Code - Sakrileg",
            "id": 311
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "Da Vinci Code",
            "id": 312
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "다빈치 코드",
            "id": 313
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "O Código Da Vinci",
            "id": 314
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "達文西密碼",
            "id": 315
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "01 Šifra mistra Leonarda",
            "id": 316
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "Robert Langdon I: The Da Vinci Code (2006)",
            "id": 317
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "Robert Langdon: 1 - El código Da Vinci",
            "id": 318
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 93,
            "title": "Կոդ Դա Վինչի",
            "id": 319
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "da vinci code",
        "sizeOnDisk": 2434490890,
        "status": "released",
        "overview": "A murder in Paris’ Louvre Museum and cryptic clues in some of Leonardo da Vinci’s most famous paintings lead to the discovery of a religious mystery. For 2,000 years a secret society closely guards information that — should it come to light — could rock the very foundations of Christianity.",
        "inCinemas": "2006-05-17T00:00:00Z",
        "physicalRelease": "2006-05-16T00:00:00Z",
        "digitalRelease": "2008-09-05T00:00:00Z",
        "releaseDate": "2006-05-16T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/64/poster.jpg?lastWrite=638849452963146430",
            "remoteUrl": "https://image.tmdb.org/t/p/original/9ejKfNk0LBhSI9AahH4f9NJNZNM.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/64/fanart.jpg?lastWrite=638792161316771001",
            "remoteUrl": "https://image.tmdb.org/t/p/original/vlnSG1EQi0ez2A6MkFfjovPfkES.jpg"
          }
        ],
        "website": "http://www.sonypictures.com/movies/thedavincicode/",
        "year": 2006,
        "youTubeTrailerId": "PHkW3TOl0-0",
        "studio": "Imagine Entertainment",
        "path": "/movies/The Da Vinci Code (2006)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 63,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/The Da Vinci Code (2006)",
        "runtime": 149,
        "cleanTitle": "thedavincicode",
        "imdbId": "tt0382625",
        "tmdbId": 591,
        "titleSlug": "591",
        "rootFolderPath": "/movies/",
        "certification": "PG-13",
        "genres": [
          "Thriller",
          "Mystery"
        ],
        "tags": [],
        "added": "2025-04-01T00:43:41Z",
        "ratings": {
          "imdb": {
            "votes": 473598,
            "value": 6.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 9559,
            "value": 6.727,
            "type": "user"
          },
          "metacritic": {
            "votes": 0,
            "value": 46,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 25,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 64,
          "relativePath": "The Da Vinci Code (2006).mp4",
          "path": "/movies/The Da Vinci Code (2006)/The Da Vinci Code (2006).mp4",
          "size": 2434490890,
          "dateAdded": "2025-04-01T01:54:16Z",
          "sceneName": "The Da Vinci Code (2006) [1080p] [YTS.AG]",
          "releaseGroup": "YTS.AG",
          "edition": "",
          "languages": [
            {
              "id": 1,
              "name": "English"
            }
          ],
          "quality": {
            "quality": {
              "id": 7,
              "name": "Bluray-1080p",
              "source": "bluray",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 1,
          "mediaInfo": {
            "audioBitrate": 126204,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "und",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 2048944,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:28:45",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "The Da Vinci Code (2006) [1080p] [YTS.AG]/The.Da.Vinci.Code.2006.1080p.BluRay.x264-[YTS.AG].mp4",
          "qualityCutoffNotMet": false,
          "id": 63
        },
        "collection": {
          "title": "Robert Langdon Collection",
          "tmdbId": 115776
        },
        "popularity": 10.0126,
        "lastSearchTime": "2025-04-01T01:39:51Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2434490890,
          "releaseGroups": [
            "YTS.AG"
          ]
        },
        "id": 64
      },
      {
        "title": "Lucifer",
        "originalTitle": "ലൂസിഫെർ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 96,
            "title": "ลูซิเฟอร์ อหังการเจ้าพ่อ",
            "id": 320
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 96,
            "title": "路西法(印度版)",
            "id": 321
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 96,
            "title": "லூசிபர்",
            "id": 322
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "lucifer",
        "sizeOnDisk": 0,
        "status": "released",
        "overview": "In God's own country, the supreme leader of the ruling party dies, leaving a huge vacuum, not only in the electoral and leadership sphere of the party but also that of the state. In the inevitable succession squabble and the power struggle that ensues, the thin line that separates good and bad becomes irrecoverably blurred and out of this seemingly endless mayhem, emerge forces that are hitherto unheard of.",
        "inCinemas": "2019-03-28T00:00:00Z",
        "digitalRelease": "2019-03-29T00:00:00Z",
        "releaseDate": "2019-03-29T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/65/poster.jpg?lastWrite=638813070631022613",
            "remoteUrl": "https://image.tmdb.org/t/p/original/fXgY2RCzoIJPhPDoyKRjaaqjIZs.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/65/fanart.jpg?lastWrite=638792211612070864",
            "remoteUrl": "https://image.tmdb.org/t/p/original/8SFdD1gwynrsj3hCtINgC1EsNzB.jpg"
          }
        ],
        "website": "",
        "year": 2019,
        "youTubeTrailerId": "",
        "studio": "Aashirvad Cinemas",
        "path": "/movies/Lucifer (2019)",
        "qualityProfileId": 1,
        "hasFile": false,
        "movieFileId": 0,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Lucifer (2019)",
        "runtime": 174,
        "cleanTitle": "lucifer",
        "imdbId": "tt6067752",
        "tmdbId": 564701,
        "titleSlug": "564701",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Drama",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-04-02T20:06:00Z",
        "ratings": {
          "imdb": {
            "votes": 14758,
            "value": 7.5,
            "type": "user"
          },
          "tmdb": {
            "votes": 63,
            "value": 7.1,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 40,
            "type": "user"
          }
        },
        "collection": {
          "title": "Lucifer Collection",
          "tmdbId": 935951
        },
        "popularity": 2.6348,
        "lastSearchTime": "2025-04-02T20:07:19Z",
        "statistics": {
          "movieFileCount": 0,
          "sizeOnDisk": 0,
          "releaseGroups": []
        },
        "id": 65
      },
      {
        "title": "L2: Empuraan",
        "originalTitle": "L2: എമ്പുരാൻ",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 97,
            "title": "L2:E",
            "id": 323
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 97,
            "title": "E.M.P.U.R.A.A.N",
            "id": 324
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "l2 empuraan",
        "sizeOnDisk": 3316594416,
        "status": "released",
        "overview": "Five years after becoming Chief Minister of Kerala, Jathin Ramdas's move to align with communal forces led by Balraj 'Baba' Bajrangi, triggers Stephen Nedumpally aka Khureshi Ab'raam to return with his Man Friday Zayed Masood to save his home state and settle scores.",
        "inCinemas": "2025-03-27T00:00:00Z",
        "digitalRelease": "2025-04-24T00:00:00Z",
        "releaseDate": "2025-04-24T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/66/poster.jpg?lastWrite=638810477798061396",
            "remoteUrl": "https://image.tmdb.org/t/p/original/dfaZipN3Aw5BK85nEvfr2FNg4EW.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/66/fanart.jpg?lastWrite=638799044499753604",
            "remoteUrl": "https://image.tmdb.org/t/p/original/jYaoVDJ9J6Me3J0EQCABzQ99YVG.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Aashirvad Cinemas",
        "path": "/movies/L2 Empuraan (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 64,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/L2 Empuraan (2025)",
        "runtime": 179,
        "cleanTitle": "l2empuraan",
        "imdbId": "tt10505918",
        "tmdbId": 627336,
        "titleSlug": "627336",
        "rootFolderPath": "/movies/",
        "certification": "NR",
        "genres": [
          "Action",
          "Crime",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-04-10T17:54:09Z",
        "ratings": {
          "imdb": {
            "votes": 11956,
            "value": 6.2,
            "type": "user"
          },
          "tmdb": {
            "votes": 15,
            "value": 6.2,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 66,
          "relativePath": "L2 Empuraan (2025).mkv",
          "path": "/movies/L2 Empuraan (2025)/L2 Empuraan (2025).mkv",
          "size": 3316594416,
          "dateAdded": "2025-04-10T17:54:20Z",
          "sceneName": "www.1TamilBlasters.red - L2 Empuraan (2025) [Malayalam - 1080p HQ-PREHD - x264 - AAC - 2.9GB - HQ Original Audio]",
          "releaseGroup": "PREHD",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "mal",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 30,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x680",
            "runTime": "2:50:35",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "www.1TamilBlasters.red - L2 Empuraan (2025) [Malayalam - 1080p HQ-PREHD - x264 - AAC - 2.9GB - HQ Original Audio].mkv",
          "qualityCutoffNotMet": false,
          "id": 64
        },
        "collection": {
          "title": "Lucifer Collection",
          "tmdbId": 935951
        },
        "popularity": 3.9961,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 3316594416,
          "releaseGroups": [
            "PREHD"
          ]
        },
        "id": 66
      },
      {
        "title": "Painkili",
        "originalTitle": "പൈങ്കിളി",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "painkili",
        "sizeOnDisk": 0,
        "status": "released",
        "overview": "Tale of Suku, who fakes insanity to escape the law. While faking insanity, he falls in love.",
        "inCinemas": "2025-02-14T00:00:00Z",
        "releaseDate": "2025-05-15T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/67/poster.jpg?lastWrite=638811342156973503",
            "remoteUrl": "https://image.tmdb.org/t/p/original/hj2VTnrshKRFi6rUKd8neP4q8qO.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/67/fanart.jpg?lastWrite=638799242101169957",
            "remoteUrl": "https://image.tmdb.org/t/p/original/mWGsTa8lqmpjvLhDsUCrqX0Dsuy.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Fahadh Faasil and Friends Private Limited",
        "path": "/movies/Painkili (2025)",
        "qualityProfileId": 1,
        "hasFile": false,
        "movieFileId": 0,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Painkili (2025)",
        "runtime": 139,
        "cleanTitle": "painkili",
        "imdbId": "tt32607369",
        "tmdbId": 1290218,
        "titleSlug": "1290218",
        "rootFolderPath": "/movies/",
        "genres": [
          "Romance",
          "Comedy"
        ],
        "tags": [],
        "added": "2025-04-10T23:23:29Z",
        "ratings": {
          "imdb": {
            "votes": 1345,
            "value": 5.2,
            "type": "user"
          },
          "tmdb": {
            "votes": 14,
            "value": 5.214,
            "type": "user"
          }
        },
        "popularity": 1.5586,
        "statistics": {
          "movieFileCount": 0,
          "sizeOnDisk": 0,
          "releaseGroups": []
        },
        "id": 67
      },
      {
        "title": "Maranamass",
        "originalTitle": "മരണമാസ്സ്‌",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 100,
            "title": "മരണ മാസ്സ്",
            "id": 325
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "maranamass",
        "sizeOnDisk": 3649940593,
        "status": "inCinemas",
        "overview": "An unlikely group of people become trapped on a bus with a man they do not realise is the serial killer terrorising their community.",
        "inCinemas": "2025-04-10T00:00:00Z",
        "releaseDate": "2025-07-09T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/68/poster.jpg?lastWrite=638804297117081075",
            "remoteUrl": "https://image.tmdb.org/t/p/original/erU6DGyYGEFrnE4reiGX3pytU2e.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/68/fanart.jpg?lastWrite=638828714648475523",
            "remoteUrl": "https://image.tmdb.org/t/p/original/hzUZ7MQjLhI3ucx33gPSgV9mMW1.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Tovino Thomas Productions",
        "path": "/movies/Maranamass (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 75,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": false,
        "folderName": "/movies/Maranamass (2025)",
        "runtime": 139,
        "cleanTitle": "maranamass",
        "imdbId": "tt32065993",
        "tmdbId": 1272121,
        "titleSlug": "1272121",
        "rootFolderPath": "/movies/",
        "genres": [
          "Comedy",
          "Drama",
          "Crime",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-04-16T19:48:31Z",
        "ratings": {
          "imdb": {
            "votes": 2423,
            "value": 6.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 4,
            "value": 5.8,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 68,
          "relativePath": "Maranamass (2025).mkv",
          "path": "/movies/Maranamass (2025)/Maranamass (2025).mkv",
          "size": 3649940593,
          "dateAdded": "2025-05-14T21:21:34Z",
          "sceneName": "www.1TamilBlasters.tw - Maranamass (2025) [Malayalam - 1080p HQ HDRip - x264 - [DDP 5.1 (448Kbps) ATMOS + AAC] - 3.2GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 448000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3 Atmos",
            "audioLanguages": "mal",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "2:16:41",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.tw - Maranamass (2025) [Malayalam - 1080p HQ HDRip - x264 - [DDP 5.1 (448Kbps) ATMOS + AAC] - 3.2GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 75
        },
        "popularity": 3.1904,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 3649940593,
          "releaseGroups": []
        },
        "id": 68
      },
      {
        "title": "Daveed",
        "originalTitle": "ദാവീദ്",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "daveed",
        "sizeOnDisk": 2997156055,
        "status": "released",
        "overview": "A celebrity bodyguard finds himself in trouble when he crosses an infamous boxer.",
        "inCinemas": "2025-02-13T00:00:00Z",
        "releaseDate": "2025-05-14T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/69/poster.jpg?lastWrite=638808731341420184",
            "remoteUrl": "https://image.tmdb.org/t/p/original/5looJkc3Siu7HqR5farCebWRxQo.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/69/fanart.jpg?lastWrite=638808731343580200",
            "remoteUrl": "https://image.tmdb.org/t/p/original/izjWBBt6pZweFfyfG47GkDBw5TC.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "John & Mary Creative",
        "path": "/movies/Daveed (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 67,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Daveed (2025)",
        "runtime": 137,
        "cleanTitle": "daveed",
        "imdbId": "tt29472286",
        "tmdbId": 1308064,
        "titleSlug": "1308064",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Drama"
        ],
        "tags": [],
        "added": "2025-04-21T22:58:51Z",
        "ratings": {
          "imdb": {
            "votes": 615,
            "value": 5.9,
            "type": "user"
          },
          "tmdb": {
            "votes": 2,
            "value": 4.5,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 69,
          "relativePath": "Daveed (2025).mkv",
          "path": "/movies/Daveed (2025)/Daveed (2025).mkv",
          "size": 2997156055,
          "dateAdded": "2025-04-21T23:10:07Z",
          "sceneName": "www.1TamilBlasters.gold - Daveed (2025) [Malayalam - 4K HEVC UNTOUCHED - x265 - [DDP5.1 (448Kbps) ATOMS + AAC] - 2.7GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 18,
              "name": "WEBDL-2160p",
              "source": "webdl",
              "resolution": 2160,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 448000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3 Atmos",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "HEVC",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "3840x2160",
            "runTime": "2:17:44",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.gold - Daveed (2025) [Malayalam - 4K HEVC UNTOUCHED - x265 - [DDP5.1 (448Kbps) ATOMS + AAC] - 2.7GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 67
        },
        "popularity": 0.8359,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2997156055,
          "releaseGroups": []
        },
        "id": 69
      },
      {
        "title": "Court: State vs. A Nobody",
        "originalTitle": "కోర్ట్: State vs. A Nobody",
        "originalLanguage": {
          "id": 45,
          "name": "Telugu"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 102,
            "title": "Court",
            "id": 329
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 102,
            "title": "Court 2025",
            "id": 330
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 102,
            "title": "Court Telugu",
            "id": 331
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "court state vs nobody",
        "sizeOnDisk": 1363206391,
        "status": "released",
        "overview": "A determined lawyer takes on a high-stakes case to defend a 19-year-old boy, challenging a system that has already branded him guilty.",
        "inCinemas": "2025-03-14T00:00:00Z",
        "digitalRelease": "2025-04-11T00:00:00Z",
        "releaseDate": "2025-04-11T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/70/poster.jpg?lastWrite=638809666575999901",
            "remoteUrl": "https://image.tmdb.org/t/p/original/4pEX67LJd7ZIqYWtksBtOgQEGcQ.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/70/fanart.jpg?lastWrite=638809666576879983",
            "remoteUrl": "https://image.tmdb.org/t/p/original/efMmUfbqfMTtheqjcWiHDtxcXbA.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "urrUjvUFhxE",
        "studio": "Wall Poster Cinema",
        "path": "/movies/Court State vs. A Nobody (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 68,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Court State vs. A Nobody (2025)",
        "runtime": 149,
        "cleanTitle": "courtstatevsnobody",
        "imdbId": "tt33307144",
        "tmdbId": 1424217,
        "titleSlug": "1424217",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama",
          "Romance",
          "Crime"
        ],
        "tags": [],
        "added": "2025-04-23T00:57:37Z",
        "ratings": {
          "imdb": {
            "votes": 6798,
            "value": 7.9,
            "type": "user"
          },
          "tmdb": {
            "votes": 10,
            "value": 7.2,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 70,
          "relativePath": "Court State vs. A Nobody (2025).mkv",
          "path": "/movies/Court State vs. A Nobody (2025)/Court State vs. A Nobody (2025).mkv",
          "size": 1363206391,
          "dateAdded": "2025-04-23T01:38:48Z",
          "sceneName": "www.1TamilBlasters.red - Court - State vs a NoBody (2025) [Tamil - 1080p HQ HD - HEVC  - x265 - [DD5.1(192Kbps) + AAC] - 1.3GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "tam/tam",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "HEVC",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "2:29:19",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.red - Court - State vs a NoBody (2025) [Tamil - 1080p HQ HD - HEVC  - x265 - [DD5.1(192Kbps) + AAC] - 1.3GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 68
        },
        "popularity": 3.7739,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1363206391,
          "releaseGroups": []
        },
        "id": 70
      },
      {
        "title": "Veera Dheera Sooran: Part 2",
        "originalTitle": "வீர தீர சூரன்: பாகம் 2",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 103,
            "title": "Chiyaan 62",
            "id": 332
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 103,
            "title": "Veera Dheera Sooran",
            "id": 333
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 103,
            "title": "VDS",
            "id": 334
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "veera dheera sooran part 2",
        "sizeOnDisk": 1635624636,
        "status": "released",
        "overview": "Kaali is a provision store owner and a loving husband and father, is brought back into the life of crime, when his former boss's son is being hunted by the police.",
        "inCinemas": "2025-03-27T00:00:00Z",
        "digitalRelease": "2025-04-24T00:00:00Z",
        "releaseDate": "2025-04-24T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/71/poster.jpg?lastWrite=638814012046862136",
            "remoteUrl": "https://image.tmdb.org/t/p/original/6iiWsXJ31BVbypWwzvoPKx24NFQ.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/71/fanart.jpg?lastWrite=638814012048262244",
            "remoteUrl": "https://image.tmdb.org/t/p/original/enbr7jaQySYFKojOQrVQFGkwrvo.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "HR Pictures",
        "path": "/movies/Veera Dheera Sooran Part 2 (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 69,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Veera Dheera Sooran Part 2 (2025)",
        "runtime": 162,
        "cleanTitle": "veeradheerasooranpart2",
        "imdbId": "tt29606499",
        "tmdbId": 1198208,
        "titleSlug": "1198208",
        "rootFolderPath": "/movies/",
        "certification": "PG-13",
        "genres": [
          "Action",
          "Crime",
          "Drama",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-04-28T01:40:04Z",
        "ratings": {
          "imdb": {
            "votes": 5110,
            "value": 6.9,
            "type": "user"
          },
          "tmdb": {
            "votes": 12,
            "value": 7.2,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 71,
          "relativePath": "Veera Dheera Sooran Part 2 (2025).mkv",
          "path": "/movies/Veera Dheera Sooran Part 2 (2025)/Veera Dheera Sooran Part 2 (2025).mkv",
          "size": 1635624636,
          "dateAdded": "2025-04-28T01:46:59Z",
          "sceneName": "www.1TamilBlasters.moi - Veera Dheera Sooran (2025) [Tamil - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.5GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "tam/tam",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "HEVC",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "2:42:08",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "www.1TamilBlasters.moi - Veera Dheera Sooran (2025) [Tamil - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.5GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 69
        },
        "popularity": 3.9112,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1635624636,
          "releaseGroups": []
        },
        "id": 71
      },
      {
        "title": "Mahaan",
        "originalTitle": "மகான்",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 104,
            "title": "Chiyaan 60",
            "id": 335
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 104,
            "title": "Maha Purusha",
            "id": 336
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 104,
            "title": "มหายาน ชายผู้ยิ่งใหญ่",
            "id": 337
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "mahaan",
        "sizeOnDisk": 4832538124,
        "status": "released",
        "overview": "A man's family leaves him when he strays from the path of ideological living in his search for personal freedom. However, as he realizes his ambitions, he also misses the presence of his son in his life. Having fulfilled his dream of becoming a billionaire, does life give him a second chance to be a father?",
        "digitalRelease": "2022-02-10T00:00:00Z",
        "releaseDate": "2022-02-10T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/72/poster.jpg?lastWrite=638848588834501260",
            "remoteUrl": "https://image.tmdb.org/t/p/original/aHBgBSHgpLHuX9jxUGISTAIDmyD.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/72/fanart.jpg?lastWrite=638848588835501335",
            "remoteUrl": "https://image.tmdb.org/t/p/original/w1UAmgGTsdV0zKKIDY3kPBWFwXa.jpg"
          }
        ],
        "website": "",
        "year": 2022,
        "youTubeTrailerId": "",
        "studio": "Seven Screen Studios",
        "path": "/movies/Mahaan (2022)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 72,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Mahaan (2022)",
        "runtime": 163,
        "cleanTitle": "mahaan",
        "imdbId": "tt12472554",
        "tmdbId": 804337,
        "titleSlug": "804337",
        "rootFolderPath": "/movies/",
        "genres": [
          "Crime",
          "Action",
          "Drama"
        ],
        "tags": [],
        "added": "2025-04-28T18:26:26Z",
        "ratings": {
          "imdb": {
            "votes": 18554,
            "value": 7.7,
            "type": "user"
          },
          "tmdb": {
            "votes": 36,
            "value": 6.764,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 72,
          "relativePath": "Mahaan (2022).mkv",
          "path": "/movies/Mahaan (2022)/Mahaan (2022).mkv",
          "size": 4832538124,
          "dateAdded": "2025-05-01T11:03:05Z",
          "sceneName": "Mahaan (2022) 1080p 10bit DS4K AMZN WEBRip x265 HEVC Tamil DD 5.1 ESub ~ TsS",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 15,
              "name": "WEBRip-1080p",
              "source": "webrip",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 384000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "tam",
            "audioStreamCount": 1,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "2:42:16",
            "scanType": "Progressive",
            "subtitles": "eng/eng"
          },
          "originalFilePath": "Mahaan (2022) 1080p 10bit DS4K AMZN WEBRip x265 HEVC Tamil DD 5.1 ESub ~ TsS.mkv",
          "qualityCutoffNotMet": false,
          "id": 72
        },
        "popularity": 4.4405,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 4832538124,
          "releaseGroups": []
        },
        "id": 72
      },
      {
        "title": "Viduthalai: Part I",
        "originalTitle": "விடுதலை: பாகம் I",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 105,
            "title": "విడుదల : పార్ట్ 1",
            "id": 338
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "viduthalai part i",
        "sizeOnDisk": 2777340187,
        "status": "released",
        "overview": "Kumaresan, a police constable, gets recruited for an operation implanted to capture Perumal Vaathiyar, who leads a separatist group dedicated to fighting against the authorities for committing atrocities against innocent village women in the name of police interrogations.",
        "inCinemas": "2023-03-30T00:00:00Z",
        "digitalRelease": "2025-01-19T00:00:00Z",
        "releaseDate": "2025-01-19T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/73/poster.jpg?lastWrite=638828714649435596",
            "remoteUrl": "https://image.tmdb.org/t/p/original/oTxPji8PY3PL0SK9e4mkt2laJKg.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/73/fanart.jpg?lastWrite=638814616361229775",
            "remoteUrl": "https://image.tmdb.org/t/p/original/zHcOppWpmIfbmbuvF98xTnqf4jk.jpg"
          }
        ],
        "website": "",
        "year": 2023,
        "youTubeTrailerId": "GYeSfq_bj_M",
        "studio": "R S Infotainment",
        "path": "/movies/Viduthalai Part I (2023)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 71,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Viduthalai Part I (2023)",
        "runtime": 146,
        "cleanTitle": "viduthalaiparti",
        "imdbId": "tt11396310",
        "tmdbId": 786345,
        "titleSlug": "786345",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Thriller",
          "Drama"
        ],
        "tags": [],
        "added": "2025-04-28T18:27:14Z",
        "ratings": {
          "imdb": {
            "votes": 11017,
            "value": 8.2,
            "type": "user"
          },
          "tmdb": {
            "votes": 38,
            "value": 8.1,
            "type": "user"
          },
          "rottenTomatoes": {
            "votes": 0,
            "value": 100,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 73,
          "relativePath": "Viduthalai Part I (2023).mkv",
          "path": "/movies/Viduthalai Part I (2023)/Viduthalai Part I (2023).mkv",
          "size": 2777340187,
          "dateAdded": "2025-04-28T21:41:47Z",
          "sceneName": "www.TamilBlasters.tools - Viduthalai Part-1 (2023) [Tamil - 1080p HD AVC UNTOUCHED - x264 - [DDP5.1 (384Kbps) + AAC] - 2.6GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 384000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "tam/tam",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "AVC",
            "videoFps": 25,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "2:32:26",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.TamilBlasters.tools - Viduthalai Part-1 (2023) [Tamil - 1080p HD AVC UNTOUCHED - x264 - [DDP5.1 (384Kbps) + AAC] - 2.6GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 71
        },
        "collection": {
          "title": "Viduthalai Collection",
          "tmdbId": 1020749
        },
        "popularity": 1.3034,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2777340187,
          "releaseGroups": []
        },
        "id": 73
      },
      {
        "title": "Viduthalai: Part II",
        "originalTitle": "விடுதலை: பாகம் II",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 106,
            "title": "Viduthalai 2",
            "id": 339
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 106,
            "title": "Vidudhala 2",
            "id": 340
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 106,
            "title": "رهایی : قسمت دوم",
            "id": 341
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "viduthalai part ii",
        "sizeOnDisk": 1682788683,
        "status": "released",
        "overview": "Troubles worsen for Kumaresan after the capture of Perumal, and soon he is confronted with having to make a choice between performing his duties as a police constable, or taking a stand for what is right.",
        "inCinemas": "2024-12-20T00:00:00Z",
        "digitalRelease": "2025-01-19T00:00:00Z",
        "releaseDate": "2025-01-19T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/74/poster.jpg?lastWrite=638814616445316304",
            "remoteUrl": "https://image.tmdb.org/t/p/original/pRofNEH4lnP9ZFUDrra01Ma81Vi.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/74/fanart.jpg?lastWrite=638826986214213775",
            "remoteUrl": "https://image.tmdb.org/t/p/original/223v5btruh9KfS0m4eVj9BnEWBn.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "HOxXrrwa_8o",
        "studio": "R S Infotainment",
        "path": "/movies/Viduthalai Part II (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 70,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Viduthalai Part II (2024)",
        "runtime": 172,
        "cleanTitle": "viduthalaipartii",
        "imdbId": "tt25434834",
        "tmdbId": 1020354,
        "titleSlug": "1020354",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Thriller",
          "Drama"
        ],
        "tags": [],
        "added": "2025-04-28T18:27:23Z",
        "ratings": {
          "imdb": {
            "votes": 16087,
            "value": 7.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 9,
            "value": 6.8,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 74,
          "relativePath": "Viduthalai Part II (2024).mkv",
          "path": "/movies/Viduthalai Part II (2024)/Viduthalai Part II (2024).mkv",
          "size": 1682788683,
          "dateAdded": "2025-04-28T21:10:46Z",
          "sceneName": "www.1TamilBlasters.men - Viduthalai Part 2 (2024) [Tamil - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.5GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "tam/tam",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "HEVC",
            "videoFps": 25,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:37:32",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "www.1TamilBlasters.men - Viduthalai Part 2 (2024) [Tamil - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.5GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 70
        },
        "collection": {
          "title": "Viduthalai Collection",
          "tmdbId": 1020749
        },
        "popularity": 1.6285,
        "lastSearchTime": "2025-04-28T18:28:54Z",
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1682788683,
          "releaseGroups": []
        },
        "id": 74
      },
      {
        "title": "Ouseppinte Osiyathu",
        "originalTitle": "ഔസേപ്പിൻ്റെ ഒസിയത്ത്",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "ouseppinte osiyathu",
        "sizeOnDisk": 1410167372,
        "status": "inCinemas",
        "overview": "An unexpected family issue sparks tensions between a father and his sons, compelling them to collectively seek a resolution.",
        "inCinemas": "2025-03-07T00:00:00Z",
        "releaseDate": "2025-06-05T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/75/poster.jpg?lastWrite=638820114581046439",
            "remoteUrl": "https://image.tmdb.org/t/p/original/7yI1qSum03V9sFNHamWJEOhLZeA.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/75/fanart.jpg?lastWrite=638820114582046516",
            "remoteUrl": "https://image.tmdb.org/t/p/original/2D0t3FNarV4KjpCIRsWYZf8C41i.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "bKKHwLkbbnk",
        "studio": "Maygoor Films",
        "path": "/movies/Ouseppinte Osiyathu (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 73,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Ouseppinte Osiyathu (2025)",
        "runtime": 119,
        "cleanTitle": "ouseppinteosiyathu",
        "tmdbId": 1226851,
        "titleSlug": "1226851",
        "rootFolderPath": "/movies/",
        "genres": [
          "Drama"
        ],
        "tags": [],
        "added": "2025-05-05T03:10:57Z",
        "ratings": {
          "tmdb": {
            "votes": 1,
            "value": 3,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 75,
          "relativePath": "Ouseppinte Osiyathu (2025).mkv",
          "path": "/movies/Ouseppinte Osiyathu (2025)/Ouseppinte Osiyathu (2025).mkv",
          "size": 1410167372,
          "dateAdded": "2025-05-05T03:11:19Z",
          "sceneName": "www.1TamilBlasters.nexus - Ouseppinte Osiyathu (2025) [Malayalam  - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.3GB - ESub",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "HEVC",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "1:57:15",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.nexus - Ouseppinte Osiyathu (2025) [Malayalam  - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.3GB - ESub.mkv",
          "qualityCutoffNotMet": false,
          "id": 73
        },
        "popularity": 0.42,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1410167372,
          "releaseGroups": []
        },
        "id": 75
      },
      {
        "title": "Hello Mummy",
        "originalTitle": "ഹലോ മമ്മി",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "hello mummy",
        "sizeOnDisk": 1747056039,
        "status": "released",
        "overview": "Boney, a carefree man finds his life turned upside down after marriage when hes forced to deal with the restless spirit of his obsessive-compulsive mother-in-law.",
        "inCinemas": "2024-11-21T00:00:00Z",
        "releaseDate": "2025-02-19T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/76/poster.jpg?lastWrite=638823605607986464",
            "remoteUrl": "https://image.tmdb.org/t/p/original/gscmBqhpsbqy52pPaxiCbiqkukR.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/76/fanart.jpg?lastWrite=638823605608506498",
            "remoteUrl": "https://image.tmdb.org/t/p/original/26t6QQWPgoAfcShoePjvG3M2ok1.jpg"
          }
        ],
        "website": "",
        "year": 2024,
        "youTubeTrailerId": "",
        "studio": "Hangover Films",
        "path": "/movies/Hello Mummy (2024)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 74,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Hello Mummy (2024)",
        "runtime": 136,
        "cleanTitle": "hellomummy",
        "imdbId": "tt31702438",
        "tmdbId": 1239991,
        "titleSlug": "1239991",
        "rootFolderPath": "/movies/",
        "genres": [
          "Fantasy",
          "Comedy"
        ],
        "tags": [],
        "added": "2025-05-09T04:09:20Z",
        "ratings": {
          "imdb": {
            "votes": 3330,
            "value": 5.5,
            "type": "user"
          },
          "tmdb": {
            "votes": 4,
            "value": 3.8,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 76,
          "relativePath": "Hello Mummy (2024).mkv",
          "path": "/movies/Hello Mummy (2024)/Hello Mummy (2024).mkv",
          "size": 1747056039,
          "dateAdded": "2025-05-09T04:30:23Z",
          "sceneName": "www.1TamilBlasters.rodeo - Hello Mummy (2024) [Malayalam - 1080p HQ HDRip - HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.6GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "HEVC",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x800",
            "runTime": "2:15:38",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.rodeo - Hello Mummy (2024) [Malayalam - 1080p HQ HDRip - HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.6GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 74
        },
        "popularity": 0.6984,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1747056039,
          "releaseGroups": []
        },
        "id": 76
      },
      {
        "title": "HIT: The Third Case",
        "originalTitle": "హిట్: ది థర్డ్ కేస్",
        "originalLanguage": {
          "id": 45,
          "name": "Telugu"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 28,
            "title": "Nani 32",
            "id": 343
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 28,
            "title": "HIT 3",
            "id": 344
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 28,
            "title": "HIT: The 3rd Case",
            "id": 346
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 28,
            "title": "追擊頭號重案：第三宗案",
            "id": 349
          },
          {
            "sourceType": "tmdb",
            "movieMetadataId": 28,
            "title": "HIT：第三個案例",
            "id": 350
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "hit third case",
        "sizeOnDisk": 3142840664,
        "status": "released",
        "overview": "The Homicide Intervention Team (HIT) sends ruthless police officer Arjun Sarkaar to find a group of killers and stop their grisly murder spree.",
        "inCinemas": "2025-04-30T00:00:00Z",
        "digitalRelease": "2025-05-29T00:00:00Z",
        "releaseDate": "2025-05-29T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/77/poster.jpg?lastWrite=638837410682385622",
            "remoteUrl": "https://image.tmdb.org/t/p/original/wT9tGyFol4RBwkjESXUWeBdnLJn.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/77/fanart.jpg?lastWrite=638847724727893189",
            "remoteUrl": "https://image.tmdb.org/t/p/original/lRPq7QMrrNvSTKMWyAwMupuWAfr.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "VOScrKrY2fM",
        "studio": "Wall Poster Cinema",
        "path": "/movies/HIT The Third Case (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 76,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/HIT The Third Case (2025)",
        "runtime": 157,
        "cleanTitle": "hitthirdcase",
        "imdbId": "tt23804696",
        "tmdbId": 1060046,
        "titleSlug": "1060046",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Crime",
          "Thriller",
          "Action"
        ],
        "tags": [],
        "added": "2025-05-25T03:37:48Z",
        "ratings": {
          "imdb": {
            "votes": 7801,
            "value": 7,
            "type": "user"
          },
          "tmdb": {
            "votes": 22,
            "value": 7.5,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 77,
          "relativePath": "HIT The Third Case (2025).mkv",
          "path": "/movies/HIT The Third Case (2025)/HIT The Third Case (2025).mkv",
          "size": 3142840664,
          "dateAdded": "2025-05-25T03:39:21Z",
          "sceneName": "www.1TamilBlasters.earth - Hit The Third Case (2025) [Tamil - 1080p HQ-HDRip - x264 - AAC - 2.9GB - HQ Original Audio]",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 0,
            "audioChannels": 2,
            "audioCodec": "AAC",
            "audioLanguages": "tam",
            "audioStreamCount": 1,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 23.976,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:33:30",
            "scanType": "Progressive",
            "subtitles": ""
          },
          "originalFilePath": "www.1TamilBlasters.earth - Hit The Third Case (2025) [Tamil - 1080p HQ-HDRip - x264 - AAC - 2.9GB - HQ Original Audio].mkv",
          "qualityCutoffNotMet": false,
          "id": 76
        },
        "collection": {
          "title": "HIT Verse",
          "tmdbId": 918344
        },
        "popularity": 14.1778,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 3142840664,
          "releaseGroups": []
        },
        "id": 77
      },
      {
        "title": "Good Bad Ugly",
        "originalTitle": "குட் பேட் அக்லி",
        "originalLanguage": {
          "id": 43,
          "name": "Tamil"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 110,
            "title": "AK63",
            "id": 345
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "good bad ugly",
        "sizeOnDisk": 1764810452,
        "status": "released",
        "overview": "AK, a powerful gangster, surrenders to the police, in hopes that his wife and son will live a peaceful life. When he is released 17 years later, he learns that his son is falsely accused of serious crimes. To protect him, he is forced to go back to his old ways, facing enemies, both old and new.",
        "inCinemas": "2025-04-09T00:00:00Z",
        "digitalRelease": "2025-05-08T00:00:00Z",
        "releaseDate": "2025-05-08T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/78/poster.jpg?lastWrite=638839899143459373",
            "remoteUrl": "https://image.tmdb.org/t/p/original/h8MRCA7lUIiUgswtaJOxlXONZuT.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/78/fanart.jpg?lastWrite=638839899145579530",
            "remoteUrl": "https://image.tmdb.org/t/p/original/5CtvMLmCdksbYqqQd812WYML2wJ.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Mythri Movie Makers",
        "path": "/movies/Good Bad Ugly (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 77,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Good Bad Ugly (2025)",
        "runtime": 139,
        "cleanTitle": "goodbadugly",
        "imdbId": "tt27540217",
        "tmdbId": 1259024,
        "titleSlug": "1259024",
        "rootFolderPath": "/movies/",
        "certification": "NR",
        "genres": [
          "Action",
          "Crime",
          "Comedy"
        ],
        "tags": [],
        "added": "2025-05-28T00:45:14Z",
        "ratings": {
          "imdb": {
            "votes": 10570,
            "value": 5.8,
            "type": "user"
          },
          "tmdb": {
            "votes": 13,
            "value": 6.3,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 78,
          "relativePath": "Good Bad Ugly (2025).mkv",
          "path": "/movies/Good Bad Ugly (2025)/Good Bad Ugly (2025).mkv",
          "size": 1764810452,
          "dateAdded": "2025-05-29T01:20:20Z",
          "sceneName": "www.1TamilBlasters.tw - Good Bad Ugly (2025) [Tamil  - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.7GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "tam/tam",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x720",
            "runTime": "2:17:39",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.tw - Good Bad Ugly (2025) [Tamil  - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.7GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 77
        },
        "popularity": 11.4491,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1764810452,
          "releaseGroups": []
        },
        "id": 78
      },
      {
        "title": "Thudarum",
        "originalTitle": "തുടരും",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [
          {
            "sourceType": "tmdb",
            "movieMetadataId": 111,
            "title": "يتبع",
            "id": 347
          }
        ],
        "secondaryYearSourceId": 0,
        "sortTitle": "thudarum",
        "sizeOnDisk": 5181029299,
        "status": "released",
        "overview": "A taxi driver finds himself embroiled in a dangerous conspiracy after his car is confiscated by a corrupt police officer.",
        "inCinemas": "2025-04-25T00:00:00Z",
        "digitalRelease": "2025-05-30T00:00:00Z",
        "releaseDate": "2025-05-30T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/79/poster.jpg?lastWrite=638841442812050566",
            "remoteUrl": "https://image.tmdb.org/t/p/original/uOTDBabtxHA6szYKQNQe9Y7rFlv.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/79/fanart.jpg?lastWrite=638841442812890629",
            "remoteUrl": "https://image.tmdb.org/t/p/original/q6tHgBlYpesjUL9NumNoGpePaGT.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Rejaputhra Visual Media",
        "path": "/movies/Thudarum (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 78,
        "monitored": false,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Thudarum (2025)",
        "runtime": 164,
        "cleanTitle": "thudarum",
        "imdbId": "tt31969600",
        "tmdbId": 1261125,
        "titleSlug": "1261125",
        "rootFolderPath": "/movies/",
        "certification": "R",
        "genres": [
          "Drama",
          "Thriller"
        ],
        "tags": [],
        "added": "2025-05-29T19:38:01Z",
        "ratings": {
          "imdb": {
            "votes": 7205,
            "value": 7.7,
            "type": "user"
          },
          "tmdb": {
            "votes": 14,
            "value": 7.6,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 79,
          "relativePath": "Thudarum (2025).mkv",
          "path": "/movies/Thudarum (2025)/Thudarum (2025).mkv",
          "size": 5181029299,
          "dateAdded": "2025-05-29T20:17:18Z",
          "sceneName": "www.1TamilBlasters.earth - Thudarum (2025) [1080p HD AVC - x264 - [Tam + Mal + Tel + Kan + Hin] - DDP5.1(192Kbps) - 4.8GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 43,
              "name": "Tamil"
            },
            {
              "id": 48,
              "name": "Malayalam"
            },
            {
              "id": 45,
              "name": "Telugu"
            },
            {
              "id": 49,
              "name": "Kannada"
            },
            {
              "id": 26,
              "name": "Hindi"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "tam/mal/tel/kan/hin",
            "audioStreamCount": 5,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x264",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x1080",
            "runTime": "2:44:58",
            "scanType": "Progressive",
            "subtitles": "eng/eng"
          },
          "originalFilePath": "www.1TamilBlasters.earth - Thudarum (2025) [1080p HD AVC - x264 - [Tam + Mal + Tel + Kan + Hin] - DDP5.1(192Kbps) - 4.8GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 78
        },
        "popularity": 7.2774,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 5181029299,
          "releaseGroups": []
        },
        "id": 79
      },
      {
        "title": "Padakkalam",
        "originalTitle": "പടക്കളം",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "padakkalam",
        "sizeOnDisk": 1571342639,
        "status": "inCinemas",
        "overview": "Four nerdy comic book enthusiasts find themselves in an unexpected adventure when their school's charming new professor turns their academic world upside down with supernatural events.",
        "inCinemas": "2025-05-08T00:00:00Z",
        "releaseDate": "2025-08-06T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/80/poster.jpg?lastWrite=638852710252102603",
            "remoteUrl": "https://image.tmdb.org/t/p/original/9m4lvnqvwppA4BIoxqcWsWna5is.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/80/fanart.jpg?lastWrite=638852710252782606",
            "remoteUrl": "https://image.tmdb.org/t/p/original/c8hXBIgdTwPtF3PhiJayD6YHqAk.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Friday Film House",
        "path": "/movies/Padakkalam (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 80,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": false,
        "folderName": "/movies/Padakkalam (2025)",
        "runtime": 123,
        "cleanTitle": "padakkalam",
        "imdbId": "tt32919734",
        "tmdbId": 1251970,
        "titleSlug": "1251970",
        "rootFolderPath": "/movies/",
        "genres": [
          "Comedy",
          "Fantasy"
        ],
        "tags": [],
        "added": "2025-06-11T20:37:04Z",
        "ratings": {
          "imdb": {
            "votes": 997,
            "value": 7.6,
            "type": "user"
          },
          "tmdb": {
            "votes": 4,
            "value": 6.5,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 80,
          "relativePath": "Padakkalam (2025).mkv",
          "path": "/movies/Padakkalam (2025)/Padakkalam (2025).mkv",
          "size": 1571342639,
          "dateAdded": "2025-06-11T20:38:49Z",
          "sceneName": "www.1TamilBlasters.fi - Padakkalam (2025) [Malayalam - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.4GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "EAC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:03:07",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.fi - Padakkalam (2025) [Malayalam - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.4GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 80
        },
        "popularity": 3.546,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1571342639,
          "releaseGroups": []
        },
        "id": 80
      },
      {
        "title": "Bromance",
        "originalTitle": "ബ്രോമാൻസ്",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "bromance",
        "sizeOnDisk": 2085061395,
        "status": "released",
        "overview": "Binto teams up with his brother's friends for a thrilling adventure to find him, leading to unexpected twists, discoveries, and unforgettable moments.",
        "inCinemas": "2025-02-14T00:00:00Z",
        "digitalRelease": "2025-04-26T00:00:00Z",
        "releaseDate": "2025-04-26T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/81/poster.jpg?lastWrite=638852710496383663",
            "remoteUrl": "https://image.tmdb.org/t/p/original/2xzgtY0d7xbqeTWdF3tDgd5WeVM.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/81/fanart.jpg?lastWrite=638852710497263667",
            "remoteUrl": "https://image.tmdb.org/t/p/original/kTx0OshQyYMMJ8EtWwV9DDKNf0R.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Ashiq Usman Productions",
        "path": "/movies/Bromance (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 79,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": true,
        "folderName": "/movies/Bromance (2025)",
        "runtime": 139,
        "cleanTitle": "bromance",
        "imdbId": "tt32135710",
        "tmdbId": 1274225,
        "titleSlug": "1274225",
        "rootFolderPath": "/movies/",
        "genres": [
          "Comedy",
          "Action"
        ],
        "tags": [],
        "added": "2025-06-11T20:37:29Z",
        "ratings": {
          "imdb": {
            "votes": 1426,
            "value": 5.4,
            "type": "user"
          },
          "tmdb": {
            "votes": 5,
            "value": 5.5,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 81,
          "relativePath": "Bromance (2025).mkv",
          "path": "/movies/Bromance (2025)/Bromance (2025).mkv",
          "size": 2085061395,
          "dateAdded": "2025-06-11T20:38:33Z",
          "sceneName": "www.1TamilBlasters.moi - Bromance (2025) [Malayalam  - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.9GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 8,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:16:22",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.moi - Bromance (2025) [Malayalam  - 1080p HQ HDRip - HEVC - x265 - [DD5.1 (192Kbps) + AAC] - 1.9GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 79
        },
        "popularity": 1.3482,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 2085061395,
          "releaseGroups": []
        },
        "id": 81
      },
      {
        "title": "Alappuzha Gymkhana",
        "originalTitle": "ആലപ്പുഴ ജിംഖാന",
        "originalLanguage": {
          "id": 48,
          "name": "Malayalam"
        },
        "alternateTitles": [],
        "secondaryYearSourceId": 0,
        "sortTitle": "alappuzha gymkhana",
        "sizeOnDisk": 1721777532,
        "status": "inCinemas",
        "overview": "A group of youngsters, after failing their plus two exams, aims to join a common college through the sports quota. They choose boxing as their sport. By luck, they manage to survive the district-level competitions. But what will happen at the higher levels?",
        "inCinemas": "2025-04-10T00:00:00Z",
        "releaseDate": "2025-07-09T00:00:00Z",
        "images": [
          {
            "coverType": "poster",
            "url": "/MediaCover/82/poster.jpg?lastWrite=638853433321941231",
            "remoteUrl": "https://image.tmdb.org/t/p/original/q4OwzcY6r2L1M1S6uYzmtzjwAqX.jpg"
          },
          {
            "coverType": "fanart",
            "url": "/MediaCover/82/fanart.jpg?lastWrite=638853433323141319",
            "remoteUrl": "https://image.tmdb.org/t/p/original/gndCUsT53TIykPAG393UqgjU69T.jpg"
          }
        ],
        "website": "",
        "year": 2025,
        "youTubeTrailerId": "",
        "studio": "Plan B Motion Pictures",
        "path": "/movies/Alappuzha Gymkhana (2025)",
        "qualityProfileId": 1,
        "hasFile": true,
        "movieFileId": 81,
        "monitored": true,
        "minimumAvailability": "released",
        "isAvailable": false,
        "folderName": "/movies/Alappuzha Gymkhana (2025)",
        "runtime": 140,
        "cleanTitle": "alappuzhagymkhana",
        "imdbId": "tt29884526",
        "tmdbId": 1245571,
        "titleSlug": "1245571",
        "rootFolderPath": "/movies/",
        "genres": [
          "Action",
          "Drama",
          "Comedy"
        ],
        "tags": [],
        "added": "2025-06-12T16:42:12Z",
        "ratings": {
          "imdb": {
            "votes": 2251,
            "value": 7.2,
            "type": "user"
          },
          "tmdb": {
            "votes": 9,
            "value": 6.3,
            "type": "user"
          }
        },
        "movieFile": {
          "movieId": 82,
          "relativePath": "Alappuzha Gymkhana (2025).mkv",
          "path": "/movies/Alappuzha Gymkhana (2025)/Alappuzha Gymkhana (2025).mkv",
          "size": 1721777532,
          "dateAdded": "2025-06-12T16:48:08Z",
          "sceneName": "www.1TamilBlasters.fi - Alappuzha Gymkhana (2025)[Malayalam - 1080p HQ HDRip HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.6GB - ESub]",
          "edition": "",
          "languages": [
            {
              "id": 48,
              "name": "Malayalam"
            }
          ],
          "quality": {
            "quality": {
              "id": 3,
              "name": "WEBDL-1080p",
              "source": "webdl",
              "resolution": 1080,
              "modifier": "none"
            },
            "revision": {
              "version": 1,
              "real": 0,
              "isRepack": false
            }
          },
          "customFormatScore": 0,
          "indexerFlags": 0,
          "mediaInfo": {
            "audioBitrate": 192000,
            "audioChannels": 5.1,
            "audioCodec": "AC3",
            "audioLanguages": "mal/mal",
            "audioStreamCount": 2,
            "videoBitDepth": 10,
            "videoBitrate": 0,
            "videoCodec": "x265",
            "videoFps": 24,
            "videoDynamicRange": "",
            "videoDynamicRangeType": "",
            "resolution": "1920x804",
            "runTime": "2:19:17",
            "scanType": "Progressive",
            "subtitles": "eng"
          },
          "originalFilePath": "www.1TamilBlasters.fi - Alappuzha Gymkhana (2025)[Malayalam - 1080p HQ HDRip HEVC - x265 - [DD5.1(192Kbps) + AAC] - 1.6GB - ESub].mkv",
          "qualityCutoffNotMet": false,
          "id": 81
        },
        "popularity": 3.3581,
        "statistics": {
          "movieFileCount": 1,
          "sizeOnDisk": 1721777532,
          "releaseGroups": []
        },
        "id": 82
      }
    ]
""".trimIndent()