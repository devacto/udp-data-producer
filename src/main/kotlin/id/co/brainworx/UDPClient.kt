package id.co.brainworx

import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.util.ArrayList
import java.util.Properties
import java.util.Random
import java.util.Scanner

object UDPClient {
    @Throws(IOException::class)
    private fun loadEnvProperties(fileName: String): Properties {
        val envProps = Properties()
        val input = FileInputStream(fileName)
        envProps.load(input)
        input.close()
        return envProps
    }

    private fun readFile(filename: String): List<String> {
        val result = ArrayList<String>()
        val file = File(filename)
        var sc: Scanner? = null
        try { sc = Scanner(file) } catch (ignored: FileNotFoundException) { }
        while (sc!!.hasNextLine()) result.add(sc.nextLine())
        return result
    }

    @Throws(Exception::class)
    private fun send(serverHost: String, serverPort: Int, clientPort: Int, data: String) {
        val clientSocket = DatagramSocket(clientPort)
        val ipAddress: InetAddress = InetAddress.getByName(serverHost)
        val sendData: ByteArray = data.toByteArray()
        val sendPacket = DatagramPacket(sendData, sendData.size, ipAddress, serverPort)
        clientSocket.send(sendPacket)
        println("SENT: $data")
        clientSocket.close()
    }

    private fun propOrDef(envProps: Properties, propName: String, default: String): String {
        val result: String = (if (envProps.getProperty(propName) != null) envProps[propName] else default) as String
        println("$propName: $result")
        return result
    }

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) { throw IllegalArgumentException("This program takes one argument: the path to an environment configuration file.") }

        val prop: Properties = loadEnvProperties(args[0])

        val numOfRecords: Int = Integer.parseInt(propOrDef(prop, "num.records", "10000"))
        val interval: Int = Integer.parseInt(propOrDef(prop, "interval", "500"))
        val clientPort: Int = Integer.parseInt(propOrDef(prop, "client.port", "10515"))
        val serverPort: Int = Integer.parseInt(propOrDef(prop, "server.port", "10514"))
        val serverHost: String = propOrDef(prop, "server.host", "localhost")
        val dummyDataFileName: String = propOrDef(prop, "data.file.name", "data/telco.txt")

        val dummyData: List<String> = readFile(dummyDataFileName)

        for (i in 0 until numOfRecords) {
            val rnd: Int = Random().nextInt(dummyData.size)
            val data = dummyData[rnd]
            send(serverHost, serverPort, clientPort, data)
            Thread.sleep(interval.toLong())
        }
    }
}
