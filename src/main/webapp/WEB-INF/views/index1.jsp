<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>Bog</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/client/css/weather-icons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/client/css/toast-notification.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/client/css/page-tour.css">
</head>
<body>
<section>
    <div class="gap2 gray-bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row merged20" id="page-contents">
                        <%@ include file="newsfeed/collg3_left.jsp"%>
                        <%@include file="newsfeed/collg6.jsp"%>
                        <%@include file="newsfeed/collg3_right.jsp"%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="js/main.min.js"></script>
<script src="js/jquery-stories.js"></script>
<script src="../../../cdnjs.cloudflare.com/ajax/libs/gsap/1.18.2/TweenMax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8c55_YHLvDHGACkQscgbGLtLRdxBDCfI"></script>
<script src="js/locationpicker.jquery.js"></script>
<script src="js/map-init.js"></script>
<script src="js/script.js"></script>
<script>
    jQuery(document).ready(function($) {

        $('#us3').locationpicker({
            location: {
                latitude: -8.681013,
                longitude: 115.23506410000005
            },
            radius: 0,
            inputBinding: {
                latitudeInput: $('#us3-lat'),
                longitudeInput: $('#us3-lon'),
                radiusInput: $('#us3-radius'),
                locationNameInput: $('#us3-address')
            },
            enableAutocomplete: true,
            onchanged: function (currentLocation, radius, isMarkerDropped) {
                // Uncomment line below to show alert on each Location Changed event
                //alert("Location changed. New location (" + currentLocation.latitude + ", " + currentLocation.longitude + ")");
            }
        });

    });
</script>

</body>
</html>