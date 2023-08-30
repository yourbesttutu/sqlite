package com.pxp.SQLite.demo.cassandra;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.redisson.config.Config;

public class SSLUtils {
  private static final Logger logger = Logger.getLogger(SSLUtils.class.getName());
  private static final String SSL_PROTOCAL_TLS_V1_2 = "TLSv1.2";

  public static SSLContext createContextByCer() {
    Properties properties = PropertiesUtility.fetchProperty();
    String sslCerDir = properties.getProperty("SSL_CER_DIR");
    try {
      File sslCer = new File(sslCerDir);
      InputStream is = new FileInputStream(sslCer);
      CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
      X509Certificate caCert = (X509Certificate) certificateFactory.generateCertificate(is);
      TrustManagerFactory trustManagerFactory =
          TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      keyStore.load(null); // You don't need the KeyStore instance to come from a file.
      keyStore.setCertificateEntry("caCert", caCert);
      trustManagerFactory.init(keyStore);
      SSLContext sslContext = SSLContext.getInstance(SSL_PROTOCAL_TLS_V1_2);
      sslContext.init(null, trustManagerFactory.getTrustManagers(), null);
      return sslContext;
    } catch (Exception e) {
      logger.log(Level.WARNING,
          "can't generate SSL Context for Cassandra, will skip SSL connection");
      return null;
    }
  }

  public static SSLContext generateSSLContextByStore() {
    Properties properties = PropertiesUtility.fetchProperty();
    String keystoreDir = properties.getProperty("SSL_KEY_STORE_FILE_DIR");
    String trustStoreDir = properties.getProperty("SSL_TRUST_STORE_FILE_DIR");
    String keystorePW = properties.getProperty("SSL_KEY_STORE_PW");
    String trustStorePW = properties.getProperty("SSL_TRUST_STORE_PW");
    try {
      KeyStore keystore = KeyStore.getInstance("JKS");
      keystore.load(new FileInputStream(keystoreDir), keystorePW.toCharArray());

      KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
      keyManagerFactory.init(keystore, keystorePW.toCharArray());

      SSLContext ret = SSLContext.getInstance(SSL_PROTOCAL_TLS_V1_2);
      KeyStore tks = KeyStore.getInstance("JKS");
      tks.load(new FileInputStream(trustStoreDir), trustStorePW.toCharArray());
      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
      trustManagerFactory.init(tks);
      ret.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
      return ret;
    } catch (Exception e) {
      logger.log(Level.WARNING,
          "can't generate SSL Context for rabbitMQ, will skip SSL connection");
      return null;
    }
  }
}
