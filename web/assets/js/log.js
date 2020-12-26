function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
		/* console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	 console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl()) ;
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present. */
	 
	
	  var firstName=profile.getName();
	  var userEmailID=profile.getEmail();
        
	  window.location="GoogleLogin?email="+firstName+"&name="+userEmailID;
	}
function onSignUp(googleUser) {
	  var profile = googleUser.getBasicProfile();
		/* console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	 console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl()) ;
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present. */
	 
	var firstName=profile.getName();
	  var userEmailID=profile.getEmail();
        
	  window.location="GoogleLogin?userEmailID="+userEmailID+"&firstName="+firstName;
	}
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
    auth2.disconnect();
  }

function onSuccess(googleUser) {
      console.log('Logged in as: ' + googleUser.getBasicProfile().getName());
    }
    function onFailure(error) {
      console.log(error);
    }
    
      function renderButton() {
      gapi.signin2.render('my-signin2', {
        'scope': 'profile email',
        'width': 240,
        'height': 50,
        'longtitle': true,
        'theme': 'dark',
        'onsuccess': onSuccess,
        'onfailure': onFailure
      });
    }

