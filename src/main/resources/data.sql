INSERT INTO pool (dcs_pool_id, incoming_pool_id, open24h, access, pool_location_type)
VALUES (
    'POOL:001232cf-8608-3939-8e70-7e3beec16eec',
    'DEESWS0008',
    TRUE,
    'PUBLIC',
    'ONSTREET'
);

INSERT INTO charging_station (dcs_cs_id, incoming_cs_id, pool_dcs_pool_id)
VALUES (
    'CHARGING_STATION:5e296c55-fe2e-313a-bf19-08f5bf35d6b6',
    'SL01577',
    'POOL:001232cf-8608-3939-8e70-7e3beec16eec'
);

INSERT INTO charge_point (dcs_cp_id, incoming_cp_id, dynamic_info_available, isonormed_id, charging_station_dcs_cs_id)
VALUES (
    'CHARGE_POINT:200a4e22-b996-3cd0-8505-7cf6f5690714',
    '+49*809*010*150850',
    TRUE,
    TRUE,
    'CHARGING_STATION:5e296c55-fe2e-313a-bf19-08f5bf35d6b6'
);

INSERT INTO connector (id, plug_type, power_level, charge_point_dcs_cp_id)
VALUES (
    1,
    'CHADEMO',
    22,
    'CHARGE_POINT:200a4e22-b996-3cd0-8505-7cf6f5690714'
);

INSERT INTO pool_location (id, city, country_code, house_number, state, street, type, zip_code, latitude, longitude, pool_dcs_pool_id)
VALUES (1,
    'München',
    'DE',
    '3a',
    'Bayern',
    'Hauptstraße',
    'ENTRY',
    '81678',
    49.138744,
    11.87634,
    'POOL:001232cf-8608-3939-8e70-7e3beec16eec'
);


INSERT INTO charging_station_auth_methods (charging_station_dcs_cs_id, auth_method)
VALUES (
    'CHARGING_STATION:5e296c55-fe2e-313a-bf19-08f5bf35d6b6',
    'REMOTE'
);







-- Insert into Pool table
--INSERT INTO pool (dcsPoolId, incomingPoolId, open24h, access, poolLocationType)
--VALUES ('POOL:001232cf-8608-3939-8e70-7e3beec16eec', 'DEESWS0008', TRUE, 'PUBLIC', 'ONSTREET');

-- Insert into PoolLocation table
--INSERT INTO poolLocation (dcsPoolId, city, countryCode, houseNumber, state, street, type, zipCode, latitude, longitude)
--VALUES ('POOL:001232cf-8608-3939-8e70-7e3beec16eec', 'München', 'DE', '3a', 'Bayern', 'Hauptstraße', 'ENTRY', '81678', 49.138744, 11.87634);

-- Insert into ChargingStation table
--INSERT INTO chargingStation (dcsCsId, incomingCsId)
--VALUES ('CHARGING_STATION:5e296c55-fe2e-313a-bf19-08f5bf35d6b6', 'SL01577');

--INSERT INTO chargePoint (dcsCpId, incomingCpId, dynamicInfoAvailable, isonormedID, chargingStationId)
--VALUES (
    --'CHARGE_POINT:200a4e22-b996-3cd0-8505-7cf6f5690714',
    --'+49*809*010*150850',
    --TRUE,
    --TRUE,
    --(SELECT id FROM chargingStation WHERE dcsCsId = 'CHARGING_STATION:5e296c55-fe2e-313a-bf19-08f5bf35d6b6')
--);
