## UDP Data Producer
Produces data over UDP. These are comma-separated data.

![asciicast](https://raw.githubusercontent.com/devacto/udp-data-producer/master/demo.gif)

### Build and Package
```
mvn clean package
```

### Run
```
java -jar target/udpclient-1.0-SNAPSHOT-jar-with-dependencies.jar configuration/dev.properties
```

### Create KSQL Stream with the data
```
CREATE STREAM udp_raw (user STRING, mod_id STRING, protocol STRING, flags STRING, accounting_reason STRING, proto_id STRING, imsi STRING, msisdn STRING, imei STRING, appid STRING, rat_type STRING, net_type STRING, gprs_device_id STRING, flow_device_id STRING, os STRING, browser_id STRING, node_id1  STRING, node_id2 STRING, node_id3  STRING, node_addr1 STRING, node_addr2 STRING, node_addr3 STRING, client_ip STRING, client_port STRING, server_ip STRING, server_port STRING, vol_in STRING, vol_out STRING, rxmit_vol_in STRING, rxmit_vol_out STRING, pkt_in STRING, pkt_out STRING, rxmit_pkt_in STRING, rxmit_pkt_out STRING, pkt_iat_in STRING, pkt_iat_out STRING, first_seen_in STRING, first_seen_out STRING, last_seen_in STRING, last_seen_out STRING, reorder_pkt STRING, first_seen STRING, last_seen STRING, record_duration STRING, client_delay STRING, first_data_delay STRING, std STRING, signalling_triggered STRING, input_port_bitmap STRING, location_type STRING, service_option STRING, teid1 STRING, teid2 STRING, perf_flags STRING, reorder_vol STRING, rxmit_pkt STRING, tcp_stamp_src STRING, max_idle STRING, pdp_ctx_activation_time STRING, network_delay STRING, subengine_num STRING, nas_node_id  STRING, calling_station_id STRING, called_station_id STRING, nas_ip STRING, apn STRING, remote_apn STRING, location STRING, cell_mccmnc STRING, imsi_mccmnc STRING, pcf_ip STRING, proxy_endpoint STRING, tcp_stamp_time STRING, teid_match_info STRING, vlan STRING, client_ip_ttl STRING, flow_id STRING, session_id STRING, test1 STRING, test2 STRING, test3 STRING, test4 STRING, test5 STRING, test6 STRING, test7 STRING) WITH (KAFKA_TOPIC='udp_raw', VALUE_FORMAT='DELIMITED');
```

### Producing the gif
```
docker run --rm -v $PWD:/data asciinema/asciicast2gif -S 1 -w 180 -h 20 https://asciinema.org/a/cUqeKwZubGwR2pKc2PXI1lo8I.json demo.gif
```
