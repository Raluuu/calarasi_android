<?php

	require_once 'DbOperation.php';

	$db = new DbOperation();

	$messages = $db->getAllPois();

	$response = array();

	$response['error'] = false;
	$response['pois'] = array();

	while($rest = $messages->fetch_assoc()){
		$temp = array();
		$temp['id']=$rest['id'];
		$temp['name']=$rest['name'];
		$temp['latLon']=$rest['latLon'];
		array_push($response['pois'],$temp);
	}

	echo json_encode($response);
