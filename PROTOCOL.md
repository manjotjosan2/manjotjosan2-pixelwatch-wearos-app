# Pixel Watch to iPhone App Protocol

## Overview
This document details the Bluetooth communication protocol between the Pixel Watch Wear OS app and the iPhone companion app.

---

## Pairing & Security
- **Protocol:** BLE (Bluetooth Low Energy)
- **Pairing flow:** PIN entry, ECDH key exchange, AES-GCM for encrypted session
- **Session resume:** Secure token stored, auto reconnect

---

## Message Types
- **Control:** Connect/disconnect, change settings (brightness, vibration, alerts)
- **Health Data:** Heart rate, steps, motion, battery, ambient (extensible)
- **Notifications:** SOS, Find Phone, emergency alerts, bidirectional triggers
- **File Transfer:** Images, firmware, config; chunked transfer, CRC, resume on failure
- **Custom:** Drawing, sensor extensions, future modules

---

## Message Format (example, pseudocode)
```json
{
  "type": "sensor",
  "sensor": "heart_rate",
  "value": 84,
  "timestamp": 1699987654
}
```
All messages are encrypted with AES-GCM, and include a HMAC for integrity.

---

## Extensibility
- Add new message types by defining a new `type` value and document in this file
- Sensor packets are versioned for forward compatibility

---

## Error Handling
- Each message type may include an `"error"` field for reporting issues
- File transfers: failure triggers resume, or error notification to app

---

## OTA Upgrade Protocol
- On new protocol versions, both apps negotiate upgrade; allow new features without breaking older ones

---

## References
- [BLE GATT Specs](https://www.bluetooth.com/specifications/gatt/)
- [iOS CoreBluetooth Docs](https://developer.apple.com/documentation/corebluetooth)
- [Android BLE Docs](https://developer.android.com/guide/topics/connectivity/bluetooth)

---

*Update this file whenever you add new features or change the protocol!*
