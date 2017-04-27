package com.example.wilder.myapplication;

import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothDevice;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class    BlueToothActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button b1, b2, b3, b4, b5;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ListView lv;
    private static final String TAG = "BluetoothConnectionServ";
    private static final String appName = "MYAPP";
    private static final UUID MY_UUID_INSECURE =
            UUID.fromString("8ce255c0-200a-11e0-ac64-0800200c9a66");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth);


        b1 = (Button) findViewById(R.id.buttonTurnOn);
        b2 = (Button) findViewById(R.id.buttonVisible);
        b3 = (Button) findViewById(R.id.buttonDevices);
        b4 = (Button) findViewById(R.id.buttonTurnOff);
        b5 = (Button) findViewById(R.id.buttonSend);
        BA = BluetoothAdapter.getDefaultAdapter();
        lv = (ListView) findViewById(R.id.listViewUsers);
    }

    public void on(View v) {
        if (!BA.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            Toast.makeText(getApplicationContext(), "Turned on", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Already on", Toast.LENGTH_LONG).show();
        }
    }

    public void off(View v) {
        BA.disable();
        Toast.makeText(getApplicationContext(), "Turned off", Toast.LENGTH_LONG).show();
    }


    public void visible(View v) {
        Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);
    }

    public void play() {
        startActivity(new Intent(getApplicationContext(), BluetoothGameActivity.class));

    }



    public void list(View v) {
        pairedDevices = BA.getBondedDevices();

        ArrayList list = new ArrayList();

        for (BluetoothDevice bt : pairedDevices) list.add(bt.getName());
        Toast.makeText(getApplicationContext(), "Showing Paired Devices", Toast.LENGTH_SHORT).show();

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                          play();
                                      }





                              //////////////////////////////// ESSAIE CONNEXION SERVER

            class ServeurBluetooth extends Thread {
                private final BluetoothServerSocket blueServerSocket;

                public ServeurBluetooth() {
                    // On utilise un objet temporaire qui sera assigné plus tard à blueServerSocket car blueServerSocket est "final"
                    BluetoothServerSocket tmp = null;
                    try {
                        // MON_UUID est l'UUID (comprenez identifiant serveur) de l'application. Cette valeur est nécessaire côté client également !
                        tmp = BA.listenUsingRfcommWithServiceRecord(appName, MY_UUID_INSECURE);
                    } catch (IOException e) {
                    }
                    blueServerSocket = tmp;
                }

                public void run() {
                    BluetoothSocket blueSocket = null;
                    // On attend une erreur ou une connexion entrante
                    while (true) {
                        try {
                            blueSocket = blueServerSocket.accept();
                        } catch (IOException e) {
                            break;
                        }
                        // Si une connexion est acceptée
                        if (blueSocket != null) {
                            // On fait ce qu'on veut de la connexion (dans un thread séparé), à vous de la créer
                            manageConnectedSocket(blueSocket);
                            try {
                                blueServerSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                }

                private void manageConnectedSocket(BluetoothSocket blueSocket) {
                }


                // On stoppe l'écoute des connexions et on tue le thread
                public void cancel() {
                    try {
                        blueServerSocket.close();
                    } catch (IOException e) {
                    }
                }
            }

            class ClientBluetooth extends Thread {
                private final BluetoothSocket blueSocket;
                private final BluetoothDevice blueDevice;

                public ClientBluetooth(BluetoothDevice device) {
                    // On utilise un objet temporaire car blueSocket et blueDevice sont "final"
                    BluetoothSocket tmp = null;
                    blueDevice = device;

                    // On récupère un objet BluetoothSocket grâce à l'objet BluetoothDevice
                    try {
                        // MON_UUID est l'UUID (comprenez identifiant serveur) de l'application. Cette valeur est nécessaire côté serveur également !
                        tmp = device.createRfcommSocketToServiceRecord(MY_UUID_INSECURE);
                    } catch (IOException e) {
                    }
                    blueSocket = tmp;
                }

                public void run() {
                    // On annule la découverte des périphériques (inutile puisqu'on est en train d'essayer de se connecter)
                    BA.cancelDiscovery();

                    try {
                        // On se connecte. Cet appel est bloquant jusqu'à la réussite ou la levée d'une erreur
                        blueSocket.connect();
                    } catch (IOException connectException) {
                        // Impossible de se connecter, on ferme la socket et on tue le thread
                        try {
                            blueSocket.close();
                        } catch (IOException closeException) {
                        }
                        return;
                    }

                    // Utilisez la connexion (dans un thread séparé) pour faire ce que vous voulez
                    manageConnectedSocket(blueSocket);
                }

                private void manageConnectedSocket(BluetoothSocket blueSocket) {
                }

                // Annule toute connexion en cours et tue le thread
                public void cancel() {
                    try {
                        blueSocket.close();
                    } catch (IOException e) {
                    }
                }
            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
