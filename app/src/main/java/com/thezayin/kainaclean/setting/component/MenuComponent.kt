package com.thezayin.kainaclean.setting.component

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.thezayin.analytics.dependencies.Analytics
import com.thezayin.analytics.events.AnalyticsEvent
import com.thezayin.analytics.qualifiers.GoogleAnalytics
import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.auth.presentation.viewmodel.AuthViewModel
import com.thezayin.kainaclean.destinations.OnBoardingScreenDestination
import com.thezayin.kainaclean.util.Response

@Composable
fun MenuComponent(
    viewModel: AuthViewModel,
    navigator: DestinationsNavigator,
    context: Context,
   @GoogleAnalytics analytics: Analytics
) {
    viewModel.signOutState.value
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 45.dp, top = 45.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    analytics.logEvent(AnalyticsEvent.PrivacySelected("privacy_selected"))
                }
                .padding(top = 35.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_list_privacy),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(22.dp)
            )
            Text(
                text = "Privacy Policy",
                modifier = Modifier.padding(start = 5.dp),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .clickable {
                    val i = Intent(Intent.ACTION_SEND)
                    i.setType("message/rfc822")
                    i.putExtra(Intent.EXTRA_EMAIL, arrayOf(" info@kainaclean.co.uk"))
                    i.putExtra(Intent.EXTRA_SUBJECT, "Android App")
                    i.putExtra(Intent.EXTRA_TEXT, "body of email")
                    try {
                        context.startActivity(Intent.createChooser(i, "Send mail..."))
                    } catch (ex: ActivityNotFoundException) {
                        Toast
                            .makeText(
                                context,
                                "There are no email clients installed.",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    analytics.logEvent(AnalyticsEvent.ContactSelected("email_selected"))
                },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(22.dp)
            )
            Text(
                text = "Contact us",
                modifier = Modifier.padding(start = 5.dp),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .clickable {
                    try {
                        val intent =
                            Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "01753 943261", null))
                        context.startActivity(intent)
                    } catch (t: Throwable) {
                        Response.Failure(t.localizedMessage ?: "Error")
                    }
                    analytics.logEvent(AnalyticsEvent.CallSelected("call_selected"))
                },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_call),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(22.dp)
            )
            Text(
                text = "Call us",
                modifier = Modifier.padding(start = 5.dp),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    analytics.logEvent(AnalyticsEvent.RateUsSelected("rate_selected"))
                }
                .padding(top = 35.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(22.dp)
            )
            Text(
                text = "Feed Back",
                modifier = Modifier.padding(start = 5.dp),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.logout()
                    analytics.logEvent(AnalyticsEvent.LogOutSelected("logout_from"))
                    navigator.navigate(OnBoardingScreenDestination)
                }
                .padding(top = 35.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logout),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(22.dp)
            )
            Text(
                text = "Log out",
                modifier = Modifier.padding(start = 5.dp),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp,
            )
        }
    }
}